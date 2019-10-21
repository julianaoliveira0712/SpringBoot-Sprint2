package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Token;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SignupController {

    private final TodosUsuarios todosUsuarios;

    @Autowired
    public SignupController(TodosUsuarios todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        if(todosUsuarios.existe(usuario.getCredenciais()) != null) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        todosUsuarios.save(usuario);
        Usuario u = todosUsuarios.porEmail(usuario.getCredenciais().getEmail());
        Token token = new Token(u, new Date().toString(), Math.random() + usuario.getNome());
        Token.tokens.add(token);
        return ResponseEntity.ok(token.valor);
    }
}
