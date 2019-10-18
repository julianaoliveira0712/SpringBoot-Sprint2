package br.com.bandtec.agendadeobjetivos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name = "moments")
public class Moments {

    @Id
    @GeneratedValue
    private int id;

    @JsonProperty
    private String owner;

    @JsonProperty
    private String type;

    @JsonProperty
    private String urlBucket;

    @JsonProperty
    private idMemoryLine

     "owner": headerRequest,
            "type": bodyRequest["typeMoment"],
            "urlBucket": bodyRequest["urlBucket"],
            "idMemoryLine": id_memory_line,
            "creationDate": datetime.now().strftime("%d/%m/%Y %H:%M:%S"),
            "description": bodyRequest["description"]



}
