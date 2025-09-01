package com.example.library.catalog.repository;

import com.example.library.catalog.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {
    List<Work> findByTitleContaining(String title);
}




