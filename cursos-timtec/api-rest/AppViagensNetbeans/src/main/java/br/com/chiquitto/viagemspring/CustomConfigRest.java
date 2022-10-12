package br.com.chiquitto.viagemspring;

import br.com.chiquitto.viagemspring.model.Hotel;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
@Configuration
public class CustomConfigRest implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        // RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
        
        config.exposeIdsFor(Hotel.class);
    }
    
    
    
}
