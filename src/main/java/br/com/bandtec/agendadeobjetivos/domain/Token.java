package br.com.bandtec.agendadeobjetivos.domain;

import java.util.ArrayList;

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

}
