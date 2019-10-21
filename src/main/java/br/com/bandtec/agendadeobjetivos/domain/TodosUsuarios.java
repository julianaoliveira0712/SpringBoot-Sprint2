package br.com.bandtec.agendadeobjetivos.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.credenciais = :credenciais")
	public Usuario existe(@Param("credenciais") Credenciais c);

	@Query("from Usuario where nome = :nome")
	public List<Usuario> porNome(@Param("nome") String nome);

	@Query("from Usuario where idade = :idade")
	public List<Usuario> porIdade(@Param("idade") Integer idade);

	@Query("from Usuario where credenciais.email = :email")
	public Usuario porEmail(@Param("email") String email);
}
