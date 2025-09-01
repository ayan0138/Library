package com.example.library.catalog.service;

import com.example.library.catalog.model.Work;
import com.example.library.catalog.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private final WorkRepository workRepository;

    // Constructor injection
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    // Create
    public Work createWork(Work work) {
        return workRepository.save(work);
    }

    // Read all
    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    // Read one by ID
    public Work getWorkById(Long id) {
        return workRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Work not found with id: " + id));
    }

    // Update
    public Work updateWork(Long id, Work work) {
        if (!workRepository.existsById(id)) {
            throw new RuntimeException("Work not found with id: " + id);
        }
        work.setId(id); // vigtigt: ellers laver save() en ny
        return workRepository.save(work);
    }

    // Delete
    public void deleteWork(Long id) {
        if (!workRepository.existsById(id)) {
            throw new RuntimeException("Work not found with id: " + id);
        }
        workRepository.deleteById(id);
    }

    // Search by title
    public List<Work> searchWorks(String title) {
        return workRepository.findByTitleContaining(title);
    }
}
