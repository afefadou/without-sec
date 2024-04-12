package org.modulemob.postesservice;

import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.repository.CollabRepository;
import org.modulemob.postesservice.repository.CompetenceRepository;
import org.modulemob.postesservice.repository.PosteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

import static org.modulemob.postesservice.enums.AccountStatus.OUVERT;

@SpringBootApplication
public class PostesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostesServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PosteRepository posteRepository,
                                               CompetenceRepository competenceRepository,
                                               CollabRepository collabRepository){
        return args -> {
            posteRepository.save(Poste.builder()
                    .id(UUID.randomUUID().toString())
                    .titre("java developer")
                    .status(OUVERT)
                    .description("open for recruit")
                    .build());
            posteRepository.save(Poste.builder()
                    .id(UUID.randomUUID().toString())
                    .titre("php developer")
                    .status(OUVERT)
                    .description("open for recruit")
                    .build());
            posteRepository.save(Poste.builder()
                    .id(UUID.randomUUID().toString())
                    .titre("project manager")
                    .status(OUVERT)
                    .description("open for recruit")
                    .build());
//            Stream.of("fida","marwen","hazem").forEach(name->{
//                Collab collab= new Collab();
//                collab.setNom(name);
//                collab.setEmail(name+"@gmail.com");
//                collabRepository.save(collab);
//                    });





        };
    }
}
