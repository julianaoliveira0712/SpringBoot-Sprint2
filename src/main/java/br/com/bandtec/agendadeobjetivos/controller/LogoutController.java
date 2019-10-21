package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class LogoutController {
    List<Credenciais> logado = new ArrayList<>();
    private final TodosUsuarios todosUsuarios;

    @Autowired
    public LogoutController(TodosUsuarios todosUsuarios, Credenciais credenciais) {
        this.todosUsuarios = todosUsuarios;
    }

    private void logout(Credenciais credenciais){
        if(todosUsuarios.existe(credenciais) != null) {
            logado.remove(credenciais);
        }
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logoutUsuario(@RequestBody Credenciais credenciais){
        logout(credenciais);
        return ResponseEntity.ok("Sucesso");
    }
}

