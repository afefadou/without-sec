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
                    .id("1p")
                    .titre("java developer")
                    .status(OUVERT)
                    .description("open for recruit")
                    .build());
            posteRepository.save(Poste.builder()
                    .id("2p")
                    .titre("php developer")
                    .status(OUVERT)
                    .description("open for recruit")
                    .build());
            posteRepository.save(Poste.builder()
                    .id("3p")
                    .titre("project manager")
                    .status(OUVERT)
                    .description("open for recruit")
                    .build());
            collabRepository.save(Collab.builder()
                    .id(1L)
                    .nom("fida")
                    .email("fida@gmail.com")
                    .build());
            collabRepository.save(Collab.builder()
                    .id(2L)
                    .nom("marwen")
                    .email("fida@gmail.com")
                    .build());
            collabRepository.save(Collab.builder()
                    .id(3L)
                    .nom("marwa")
                    .email("fida@gmail.com")
                    .build());
            collabRepository.save(Collab.builder()
                    .id(4L)
                    .nom("seif")
                    .email("fida@gmail.com")
                    .build());
            competenceRepository.save(Competence.builder()
                    .id("1")
                    .nom("java")
                    .description("Some Description")
                    .build());
            competenceRepository.save(Competence.builder()
                    .id("2")
                    .nom("php")
                    .description("Some Description")
                    .build());
            competenceRepository.save(Competence.builder()
                    .id("3")
                    .nom("c")
                    .description("Some Description")
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
