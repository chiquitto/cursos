package br.com.chiquitto.appviagens.services;

import br.com.chiquitto.appviagens.model.Hotel;
import br.com.chiquitto.appviagens.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HoteisService {

    @Autowired
    private HotelRepository hotelRepository;

    @RequestMapping(path = "/services/hoteis")
    public ResponseEntity<List<Hotel>> findByCidade(
            String cidade,
            @RequestHeader(name="X-Api-Version", defaultValue = "1.0") String apiVersion
    ) {
        System.out.println("Versão da API:" + apiVersion);

        List<Hotel> hoteis = hotelRepository.findByCidade(cidade);

        StringBuilder builder = new StringBuilder();

        for (Hotel hotel : hoteis) {
            hotel.add(Link.valueOf("</services/quartos/1>; title=\"Quarto basico 1\"; rel=\"quarto\""));
            hotel.add(Link.valueOf("</services/quartos/2>; title=\"Quarto luxo 1\"; rel=\"quarto\""));

            DigestUtils.appendMd5DigestAsHex(new byte[]{hotel.getVersion().byteValue()}, builder);
            DigestUtils.appendMd5DigestAsHex(hotel.getNome().getBytes(), builder);
            DigestUtils.appendMd5DigestAsHex(hotel.getEndereco().getBytes(), builder);
            DigestUtils.appendMd5DigestAsHex(hotel.getCidade().getBytes(), builder);
        }

        return ResponseEntity
                .ok()
                .eTag(builder.toString())
                .body(hoteis);
    }

}
