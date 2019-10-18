package br.com.bandtec.agendadeobjetivos.domain;

import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="memoryline")
public class MemoryLine {

	@Id
	@GeneratedValue
	private int idMemoryLine;

	@JsonProperty
	private  String idOwner;

//    @JsonProperty
//    private List<String> psrticipantes;

	@JsonProperty
	private String creationDate;

	@JsonProperty
	private String name;



	public Integer getIdMemoryLine() {
		return idMemoryLine;
	}

	public void setIdMemoryLine(Integer idMoments) {
		this.idMemoryLine = idMoments;
	}

	public String getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
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

}
