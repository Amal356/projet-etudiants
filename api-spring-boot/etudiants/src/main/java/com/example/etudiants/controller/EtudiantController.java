package com.example.etudiants.controller;

import com.example.etudiants.dto.EtudiantDTO;
import com.example.etudiants.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @GetMapping
    public List<EtudiantDTO> getAll(
            @RequestParam(required = false) Integer annee) {
        if (annee != null) {
            return etudiantService.findByAnnee(annee);
        }
        return etudiantService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(etudiantService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EtudiantDTO> create(@RequestBody EtudiantDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(etudiantService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDTO> update(
            @PathVariable Long id, @RequestBody EtudiantDTO dto) {
        return ResponseEntity.ok(etudiantService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        etudiantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}