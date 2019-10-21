package br.com.bandtec.agendadeobjetivos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "moment")
public class Moments {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty
    private String type;

    @JsonProperty
    private String urlBucket;

    @ManyToOne
    @JoinColumn(name = "memoryLine")
    private MemoryLine memoryLine;

    @JsonProperty
    private String description;

    public Moments() {
    }

    public Moments(String type, String urlBucket, String description) {
        this.type = type;
        this.urlBucket = urlBucket;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlBucket() {
        return urlBucket;
    }

    public void setUrlBucket(String urlBucket) {
        this.urlBucket = urlBucket;
    }

    public void setMemoryLine(MemoryLine memoryLine) {
        this.memoryLine = memoryLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
