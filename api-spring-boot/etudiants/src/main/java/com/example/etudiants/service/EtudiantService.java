package com.example.etudiants.service;

import com.example.etudiants.dto.EtudiantDTO;
import com.example.etudiants.entity.Etudiant;
import com.example.etudiants.mapper.EtudiantMapper;
import com.example.etudiants.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    @Cacheable(value = "etudiants")
    public List<EtudiantDTO> findAll() {
        return etudiantRepository.findAll()
                .stream()
                .map(etudiantMapper::toDTO)
                .toList();
    }

    public EtudiantDTO findById(Long id) {
        Etudiant e = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé : " + id));
        return etudiantMapper.toDTO(e);
    }

    @CacheEvict(value = "etudiants", allEntries = true)
    public EtudiantDTO save(EtudiantDTO dto) {
        Etudiant e = etudiantMapper.toEntity(dto);
        return etudiantMapper.toDTO(etudiantRepository.save(e));
    }

    @CacheEvict(value = "etudiants", allEntries = true)
    public EtudiantDTO update(Long id, EtudiantDTO dto) {
        Etudiant e = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé : " + id));
        e.setCin(dto.getCin());
        e.setNom(dto.getNom());
        e.setDateNaissance(dto.getDateNaissance());
        e.setEmail(dto.getEmail());
        e.setAnneePremiereInscription(dto.getAnneePremiereInscription());
        return etudiantMapper.toDTO(etudiantRepository.save(e));
    }

    @CacheEvict(value = "etudiants", allEntries = true)
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }

    public List<EtudiantDTO> findByAnnee(int annee) {
        return etudiantRepository.findByAnneePremiereInscription(annee)
                .stream()
                .map(etudiantMapper::toDTO)
                .toList();
    }
}