package br.com.chiquitto.appviagens.services;

import br.com.chiquitto.appviagens.model.Hotel;
import br.com.chiquitto.appviagens.model.Quarto;
import br.com.chiquitto.appviagens.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuartosService {

    // @Autowired
    // private HotelRepository hotelRepository;

    @RequestMapping(path = "/services/quartos/{id}")
    public Quarto showQuarto(@PathVariable("id") String id) {

        // Hotel hotel = hotelRepository.getOne(1);

        Hotel hotel = new Hotel();
        hotel.setIdHotel(1);
        hotel.setNome("Hotel Central");
        hotel.setEndereco("Rua Central 12345");

        Quarto quarto = new Quarto();
        quarto.setIdQuarto(Integer.valueOf(id));
        quarto.setHotel(hotel);
        quarto.setTipo("Basico");

        quarto.add(Link.valueOf("</services/quartos/" + id + "/disponibilidade>; rel=\"disponibilidade\""));

        return quarto;
    }

}
