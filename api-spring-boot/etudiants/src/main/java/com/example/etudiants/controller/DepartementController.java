package com.example.etudiants.controller;

import com.example.etudiants.entity.Departement;
import com.example.etudiants.service.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departements")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DepartementController {

    private final DepartementService departementService;

    @GetMapping
    public List<Departement> getAll() {
        return departementService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departementService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Departement> create(@RequestBody Departement departement) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departementService.save(departement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> update(
            @PathVariable Long id, @RequestBody Departement departement) {
        return ResponseEntity.ok(departementService.update(id, departement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}