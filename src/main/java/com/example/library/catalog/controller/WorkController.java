package com.example.library.catalog.controller;

import com.example.library.catalog.model.Work;
import com.example.library.catalog.service.WorkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    // GET /api/works  (optionally filter by title via ?title=)
    @GetMapping("/api/works")
    public List<Work> getAll(@RequestParam(required = false) String title) {
        if (title == null || title.isBlank()) return workService.getAllWorks();
        return workService.searchWorks(title);
    }

    // GET /api/works/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Work> getOne(@PathVariable Long id) {
        Work w = workService.getWorkById(id);
        return ResponseEntity.ok(w);
    }

    // POST /api/works
    @PostMapping("/api/works")
    public ResponseEntity<Work> create(@RequestBody Work work) {
        Work saved = workService.createWork(work);
        return ResponseEntity.created(URI.create("/api/works/" + saved.getId())).body(saved);
    }

    // PUT /api/works/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Work> update(@PathVariable Long id, @RequestBody Work work) {
        Work updated = workService.updateWork(id, work);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/works/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workService.deleteWork(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/works/search?title=foo   (separate route if you prefer)
    @GetMapping("/search")
    public List<Work> search(@RequestParam String title) {
        return workService.searchWorks(title);
    }
}
