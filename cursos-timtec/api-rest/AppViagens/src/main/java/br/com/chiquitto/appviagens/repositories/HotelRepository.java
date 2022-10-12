package br.com.chiquitto.appviagens.repositories;

import br.com.chiquitto.appviagens.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
@RepositoryRestResource(path="hoteis")
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    public List<Hotel> findByCidade(@Param("cidade") String cidade);

}
