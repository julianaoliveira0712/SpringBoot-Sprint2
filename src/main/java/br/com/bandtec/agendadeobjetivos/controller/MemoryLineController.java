package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoryLineController {

    private final TodosMemoryLine todosMemoryLine;
    private final TodosUsuarios todosUsuarios;

    @Autowired
    public MemoryLineController(TodosMemoryLine todosMemoryLine, TodosUsuarios todosUsuarios) {
        this.todosMemoryLine = todosMemoryLine;
        this.todosUsuarios = todosUsuarios;
    }

    @PostMapping("/memory-line")
    public ResponseEntity<String> cadastrarMemoryLine(@RequestHeader String idToken, @RequestBody MemoryLine memoryLine) {
        Token token = Token.getToken(idToken);

        if(token == null)
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem acesso");

        Usuario u = todosUsuarios.findById(token.getUsuario().getId()).get();
        u.addMemoryLine(memoryLine);
        todosUsuarios.save(u);
        return ResponseEntity.ok("Cadastro com sucesso");
    }

    @GetMapping("/memory-line")
    public ResponseEntity<List<MemoryLine>> allMemoryLine(@RequestHeader String idToken) {
        Token token = Token.getToken(idToken);

        if(token == null)
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem acesso");

        Usuario u = todosUsuarios.findById(token.getUsuario().getId()).get();

        return ResponseEntity.ok(todosMemoryLine.findByOwner(u));
    }
}
