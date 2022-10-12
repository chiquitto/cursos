package br.com.chiquitto.appviagens.services;

import br.com.chiquitto.appviagens.model.Disponibilidade;
import br.com.chiquitto.appviagens.model.Hotel;
import br.com.chiquitto.appviagens.model.Quarto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DisponibilidadeService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(path = "/disponibilidade/{data}")
    public Disponibilidade recuperarDisponibilidadeParaData(@PathVariable("data") String data) throws ParseException {
        Date date;


        Hotel hotel = new Hotel();
        hotel.setIdHotel(1);
        hotel.setNome("Caiua");
        hotel.setEndereco("Rua Central 12345");

        Quarto quarto = new Quarto();
        quarto.setHotel(hotel);
        quarto.setTipo("Basico");

        Disponibilidade d = new Disponibilidade();
        d.setHotel(hotel);
        d.setQuarto(quarto);
        d.setData(sdf.parse(data));

        return d;
    }

}
