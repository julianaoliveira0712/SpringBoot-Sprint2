package br.com.bandtec.agendadeobjetivos.domain;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Token {

    public static ArrayList<Token> tokens = new ArrayList<>();
    public Usuario usuario;
    public String data;
    public String valor;

    public Token() { }

    public static Token getToken(String idToken) {
        for (int i = 0; i < tokens.size(); i++) {
            if(tokens.get(i).valor.equals(idToken))
                return tokens.get(i);
        }

        return null;
    }

    public Token(Usuario usuario, String data, String valor) {
        this.usuario = usuario;
        this.data = data;
        this.valor = valor;
    }

    public static void addToken(Token token) {
        List<Usuario> usuarios = lerArquivo("historico", true);
        usuarios.add(token.getUsuario());
        gravaArquivo(usuarios, "historico", true);
        tokens.add(token);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public static void gravaArquivo(List<Usuario> lista, String nomeArq, boolean isCSV) {
        FileWriter arq = null;
        Formatter saida = null;
        String nomeArquivo;

        if (isCSV) {
            nomeArquivo = nomeArq + ".csv";
        }
        else {
            nomeArquivo = nomeArq + ".txt";
        }

        try {
            arq = new FileWriter(nomeArquivo, true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo.");
        }

        try {
            for (int i=0; i < lista.size(); i++) {
                Usuario a = lista.get(i);
                if (isCSV) {
                    saida.format("%s;%s;%s;%s;%s;%s",
                            a.getId().toString(),
                            a.getNome(),
                            a.getNickname(),
                            a.getDataNascimento(),
                            a.getCredenciais().getEmail(),
                            a.getCredenciais().getSenha());
                }
                else {
                    saida.format("%s %s %s %s %s %s",
                            a.getId().toString(),
                            a.getNome(),
                            a.getNickname(),
                            a.getDataNascimento(),
                            a.getCredenciais().getEmail(),
                            a.getCredenciais().getSenha());
                }
            }
        }
        catch (FormatterClosedException erro)
        {
            System.err.println("Erro ao gravar no arquivo.");
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
            }
        }
    }

    public static List<Usuario> lerArquivo(String nomeArq, boolean isCSV) {
        FileReader arq= null;
        Scanner entrada = null;
        String nomeArquivo;
        List<Usuario> usuarios = new ArrayList<>();

        if (isCSV) {
            nomeArquivo = nomeArq + ".csv";
        }
        else {
            nomeArquivo = nomeArq + ".txt";
        }

        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }
            else {
                entrada = new Scanner(arq);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo n�o encontrado");
        }

        try {
            while (entrada.hasNext()) {
                Long id = entrada.nextLong();
                String nome = entrada.next();
                String nickname = entrada.next();
                String dataNascimento = entrada.next();
                String email = entrada.next();
                String senha = entrada.next();

                Usuario u = new Usuario(
                        id,
                        new Credenciais(email, senha),
                        nome,
                        nickname,
                        dataNascimento
                );

                usuarios.add(u);
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
            }
        }

        return usuarios;
    }
}