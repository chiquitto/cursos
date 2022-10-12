package br.com.chiquitto.appviagens;

import br.com.chiquitto.appviagens.services.DisponibilidadeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class AppviagensApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppviagensApplication.class, args);
    }

}
