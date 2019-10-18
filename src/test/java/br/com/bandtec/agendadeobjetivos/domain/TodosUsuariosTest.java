package br.com.bandtec.agendadeobjetivos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosUsuariosTest {
	
	@Autowired
	private TodosUsuarios todosUsuarios;
	
	private Usuario umUsuario;
	
	@Before
	public void setUp() {
		umUsuario = new Usuario("nome", 45, new Credenciais("login", "senha"));
	}
	
	//ensinar @Transactional, e não o after
	/*@After
	public void tearDown() {
		todosUsuarios.delete(umUsuario);
	}*/
	
	@Test
	public void buscarUsuarioInexistente() {
		Usuario inexistente = todosUsuarios.existe(new Credenciais("rodrigovp", "senha"));
		
		assertNull(inexistente);
	}
	
	@Test
	public void buscarUsuarioExistente() {
		todosUsuarios.save(umUsuario);
		
		Usuario usuarioNoBanco = todosUsuarios.existe(new Credenciais("login", "senha"));
		
		assertEquals(umUsuario, usuarioNoBanco);
	}
	
	@Test
	public void buscarUsuarioPorNome() {
		todosUsuarios.save(umUsuario);
		
		List<Usuario> usuariosPorNome = todosUsuarios.porNome(umUsuario.getNome());
		
		assertEquals(1, usuariosPorNome.size());
		assertEquals(umUsuario, usuariosPorNome.get(0));
	}
	
	@Test
	public void buscarENaoEncontrarUsuarioPorNome() {
		todosUsuarios.save(umUsuario);
		
		List<Usuario> usuariosPorNome = todosUsuarios.porNome("inexistente");
		
		assertEquals(0, usuariosPorNome.size()); //ou
		assertTrue(usuariosPorNome.isEmpty());
	}
	
	@Test
	public void buscarUsuarioPorIdade() {
		todosUsuarios.save(umUsuario);
		
		List<Usuario> usuariosPorIdade = todosUsuarios.porIdade(umUsuario.getIdade());
		
		assertEquals(1, usuariosPorIdade.size());
		assertEquals(umUsuario, usuariosPorIdade.get(0));
	}
	
	@Test
	public void buscarENaoEncontrarUsuarioPorIdade() {
		todosUsuarios.save(umUsuario);
		
		List<Usuario> usuariosPorIdade = todosUsuarios.porIdade(44);
		
		assertEquals(0, usuariosPorIdade.size()); //ou
		assertTrue(usuariosPorIdade.isEmpty());
	}
}
