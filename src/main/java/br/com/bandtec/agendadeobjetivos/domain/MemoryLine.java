package br.com.bandtec.agendadeobjetivos.domain;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="memoryline")
public class MemoryLine {

	@Id
	@GeneratedValue
	private Long idMemoryLine;

	@JsonProperty
	private String creationDate;

	@JsonProperty
	private String name;

	@OneToMany(mappedBy = "memoryLine", cascade = CascadeType.ALL)
	private List<Moments> moment;

	@ManyToOne
	@JoinColumn(name = "owner")
	private Usuario owner;

	public MemoryLine() {

	}

	public MemoryLine(String creationDate, String name) {
		this.creationDate = creationDate;
		this.name = name;
	}

	public Long getIdMemoryLine() {
		return idMemoryLine;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	public void addMoment(Moments moments) {
		moment.add(moments);
		moments.setMemoryLine(this);
	}

	public List<Moments> getMoment() {
		return moment;
	}
}
