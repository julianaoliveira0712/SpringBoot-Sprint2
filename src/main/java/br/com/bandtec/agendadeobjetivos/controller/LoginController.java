package br.com.bandtec.agendadeobjetivos.controller;

import br.com.bandtec.agendadeobjetivos.domain.Token;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

import java.util.Date;

@RestController
public class LoginController {

	private final TodosUsuarios todosUsuarios;
	
	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> efetuarLogin(@RequestBody Credenciais credenciais) {
		Usuario usuario = todosUsuarios.existe(credenciais);

		if(usuario == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login/senha não conferem");
		}
		Usuario u = todosUsuarios.porEmail(usuario.getCredenciais().getEmail());
		Token token = new Token(u, new Date().toString(), Math.random() + usuario.getNome());
		Token.addToken(token);
		return ResponseEntity.ok(token.valor);
	}

}
