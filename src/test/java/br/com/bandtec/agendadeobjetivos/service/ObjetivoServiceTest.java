package br.com.bandtec.agendadeobjetivos.service;

import static java.time.LocalDate.now;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;
import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

public class ObjetivoServiceTest {
	
	private TodosObjetivos todosObjetivos;
	private TodosUsuarios todosUsuarios;
	
	private ObjetivoService service;
	
	@Before
	public void setUp() {
		this.todosObjetivos = mock(TodosObjetivos.class);
		this.todosUsuarios = mock(TodosUsuarios.class);
		service = new ObjetivoService(todosObjetivos, todosUsuarios);
	}
	
	@Test
	public void associarUmUsuarioAUmObjetivo() {
		Long usuarioId = 3L;
		Usuario usuario = new Usuario("Rodrigo", 39, 
				new Credenciais("login", "senha"));
		Objetivo objetivo = new Objetivo("titulo", "descricao", now(), 
				new Prioridade("baixa", "nenhuma observação")); 
		
		when(todosUsuarios.getOne(usuarioId)).thenReturn(usuario);
		
		service.salvarObjetivo(usuarioId, objetivo);
		
		verify(todosObjetivos).save(objetivo);
		assertEquals(usuario, objetivo.getUsuario());
	}
}
