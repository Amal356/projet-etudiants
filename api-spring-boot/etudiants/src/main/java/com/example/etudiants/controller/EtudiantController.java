package com.example.etudiants.controller;

import com.example.etudiants.entity.Etudiant;
import com.example.etudiants.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EtudiantController {

    private final EtudiantRepository etudiantRepository;

    @GetMapping
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }
}