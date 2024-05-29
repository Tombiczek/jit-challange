package internship.java.java_internship;

import internship.java.java_internship.model.Visit;
import internship.java.java_internship.model.VisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;


@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(VisitRepository repository) {
        return args -> {
            log.info("Preloading {}", repository.save(new Visit(
                    LocalDate.parse("2025-05-05"), "Tomasz", "Puszek", 5, "Czarny")));
            log.info("Preloading {}", repository.save(new Visit(
                    LocalDate.parse("2025-02-12"), "Michal", "Kotek", 2, "Bialy")));
        };
    }
}


