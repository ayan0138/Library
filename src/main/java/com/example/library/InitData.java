package com.example.library.common;

import com.example.library.catalog.model.Work;
import com.example.library.catalog.model.WorkType;
import com.example.library.catalog.repository.WorkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final WorkRepository workRepository;

    public InitData(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Work w1 = new Work();
        w1.setTitle("Clean Code Java");
        w1.setWorkType(WorkType.BOOK);
        w1.setDetails("A book about software architecture by Robert C. Martin");
        w1.setAuthors("Robert C. Martin");
        w1.setSubjects("Architecture, Software");

        Work w2 = new Work();
        w2.setTitle("Learn Java in 30 minutes");
        w2.setWorkType(WorkType.VIDEO);
        w2.setDetails("Java best practices");
        w2.setAuthors("Joshua Bloch");
        w2.setSubjects("Java, Programming");

        Work w3 = new Work();
        w3.setTitle("Spring Boot Guide");
        w3.setWorkType(WorkType.ARTICLE);
        w3.setDetails("Intro to Spring Boot");
        w3.setAuthors("Spring Team");
        w3.setSubjects("Spring, Framework");

        // save them
      workRepository.saveAll(List.of(w1, w2, w3));

       /* workRepository.save(w1);
        workRepository.save(w2);
        workRepository.save(w3); OR THIS WAY SEPERATED */
    }
}
