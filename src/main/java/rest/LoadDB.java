package rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j
public class LoadDB {

    @Bean
    CommandLineRunner initDatabase(GameRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Game("Metal Gear 3", new Date())));
            log.info("Preloading " + repository.save(new Game("FF 7", new Date())));

        };
    }
}
