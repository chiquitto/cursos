package br.com.chiquitto.appviagens.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
@Entity
public class Hotel extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer idHotel;

    private String nome;
    private String endereco;
    private String cidade;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer id) {
        this.idHotel = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
