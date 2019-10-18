package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;

@RestController
public class LoginController {

	private final TodosUsuarios todosUsuarios;
	private final TodosUsuarios Usuario;

	@Autowired
	public LoginController(TodosUsuarios todosUsuarios, TodosUsuarios usuarios) {
		this.todosUsuarios = todosUsuarios;
		Usuario = usuarios;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> efetuarLogin(@RequestBody Usuario usuario) {
		ResponseEntity<String> resposta = ResponseEntity.ok("Sucesso");
		//if(!credenciais.iguais()) {
		if(todosUsuarios.existe("login","senha") == null) {
			resposta = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login/senha não conferem");
		}
		return resposta;
	}

}
