package br.com.bandtec.agendadeobjetivos.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.email = :login and senha = :senha")
	public Usuario existe(@Param("login") String login, @Param("senha") String senha);

	@Query("from Usuario where nome = :nome")
	public List<Usuario> porNome(@Param("nome") String nome);

	@Query("from Usuario where email = :email")
	public List<Usuario> porEmail(@Param("email") String email);

	@Query("delete u from Usuario e where credenciais = credenciais")
	public  List<Credenciais> deleteUser(@Param("credenciais")Credenciais credenciais);
}
