package br.com.bandtec.agendadeobjetivos.domain;

import java.util.List;

import javax.persistence.*;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	@JsonProperty
	private Credenciais credenciais;

	@JsonProperty
	private String nome;

	@JsonProperty
	private String nickname;

	@JsonProperty
	private String dataNascimento;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<MemoryLine> memoryLines;

	public Usuario() {}

	public Usuario(Credenciais credenciais, String nome, String nickname, String dataNascimento) {
		this.credenciais = credenciais;
		this.nome = nome;
		this.nickname = nickname;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public Credenciais getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void addMemoryLine(MemoryLine memoryLine) {
		memoryLines.add(memoryLine);
		memoryLine.setOwner(this);
	}

	public List<MemoryLine> getMemoryLines() {
		return memoryLines;
	}
}
