package br.com.bandtec.agendadeobjetivos.domain;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty
	private Credenciais credenciais;

	@JsonProperty
	private String nome;

	@JsonProperty
	private String email;

	public Usuario() {}
	
	public Usuario(String nome, String email, Credenciais credenciais) {
		this.nome = nome;
		this.email = email;
		this.credenciais = credenciais;
	}

}
