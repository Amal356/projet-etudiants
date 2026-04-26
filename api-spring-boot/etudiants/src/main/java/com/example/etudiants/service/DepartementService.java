package com.example.etudiants.service;

import com.example.etudiants.entity.Departement;
import com.example.etudiants.repository.DepartementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementService {

    private final DepartementRepository departementRepository;

    public List<Departement> findAll() {
        return departementRepository.findAll();
    }

    public Departement findById(Long id) {
        return departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departement non trouvé : " + id));
    }

    public Departement save(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement update(Long id, Departement departement) {
        Departement d = findById(id);
        d.setNom(departement.getNom());
        return departementRepository.save(d);
    }

    public void delete(Long id) {
        departementRepository.deleteById(id);
    }
}