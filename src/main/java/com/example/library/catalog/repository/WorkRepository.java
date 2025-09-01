package com.example.library.catalog.repository;

import com.example.library.catalog.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {
    List<Work> findByTitleContaining(String title);
}
