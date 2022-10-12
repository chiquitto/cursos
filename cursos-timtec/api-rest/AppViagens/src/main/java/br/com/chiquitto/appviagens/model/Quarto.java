package br.com.chiquitto.appviagens.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quarto extends RepresentationModel {

    @Id
    @GeneratedValue
    private Integer idQuarto;
    private String tipo;
    @ManyToOne
    private Hotel hotel;

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer id) {
        this.idQuarto = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
