package br.com.bandtec.agendadeobjetivos.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

public class LoginControllerTest {
	
//	private LoginController controller;
//	private TodosUsuarios todosUsuarios;
//
//	@Before
//	public void setUp() {
//		todosUsuarios = mock(TodosUsuarios.class);
//		controller = new LoginController(todosUsuarios);
//	}
//
//	@Test
//	public void loginComSucesso() {
//		Credenciais c = new Credenciais("login", "senha");
//		when(todosUsuarios.existe(c)).thenReturn(new Usuario("rodrigo", 39, c));
//		ResponseEntity<String> resposta = controller.efetuarLogin(c);
//
//		assertThat(resposta.getStatusCode(), is(equalTo(HttpStatus.OK)));
//	}
//
//	@Test
//	public void loginComFalha() {
//		ResponseEntity<String> resposta = controller.efetuarLogin(new Credenciais("login", "com erro"));
//
//		assertThat(resposta.getStatusCode(), is(equalTo(HttpStatus.UNAUTHORIZED)));
//	}
}
