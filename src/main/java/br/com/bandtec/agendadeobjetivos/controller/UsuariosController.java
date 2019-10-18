package br.com.bandtec.agendadeobjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;

@RestController
public class UsuariosController {
	
	private final TodosUsuarios todosUsuarios;
	
	@Autowired
	public UsuariosController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome) {
		List<Usuario> usuariosPorNome = todosUsuarios.porNome(nome);
		if(usuariosPorNome.isEmpty()) return ResponseEntity.noContent().build();
		else return ResponseEntity.ok(usuariosPorNome);
	}
	
	@GetMapping("/usuarios/email/{emailDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("emailDoUsuario") String email){
		List<Usuario> usuariosPorEmail = todosUsuarios.porEmail(email);
		if(usuariosPorEmail.isEmpty()) return ResponseEntity.noContent().build();
		else return ResponseEntity.ok(usuariosPorEmail);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario){
		todosUsuarios.save(usuario);
		return ResponseEntity.ok("Sucesso");
	}
}
