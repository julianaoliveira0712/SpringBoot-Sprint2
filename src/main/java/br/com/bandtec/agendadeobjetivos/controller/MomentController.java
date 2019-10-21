package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MomentController {

    private final TodosMoments todosMoments;
    private final TodosMemoryLine todosMemoryLine;

    @Autowired
    public MomentController(TodosMoments todosMoments, TodosMemoryLine todosMemoryLine) {
        this.todosMoments = todosMoments;
        this.todosMemoryLine = todosMemoryLine;
    }

    @PostMapping("/moment/{id-memory-line}")
    public ResponseEntity<String> cadastrarMoment(
            @RequestHeader String idToken,
            @RequestBody Moments moments,
            @PathVariable("id-memory-line") Long idMemoryLine) {
        Token token = Token.getToken(idToken);

        if(token == null)
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem acesso");

        MemoryLine memoryLine = todosMemoryLine.findById(idMemoryLine).get();
        memoryLine.addMoment(moments);
        todosMemoryLine.save(memoryLine);
        return ResponseEntity.ok("Cadastro com sucesso");
    }

    @GetMapping("/moment/{id-memory-line}")
    public ResponseEntity<List<Moments>> allMoment(
            @RequestHeader String idToken,
            @PathVariable("id-memory-line") Long idMemoryLine
    ) {
        Token token = Token.getToken(idToken);
        if(token == null)
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem acesso");

        MemoryLine memoryLine = todosMemoryLine.findById(idMemoryLine).get();
        return ResponseEntity.ok(todosMoments.findByMemoryLine(memoryLine));
    }
}
