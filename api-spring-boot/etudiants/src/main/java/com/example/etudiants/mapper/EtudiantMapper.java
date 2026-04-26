package com.example.etudiants.mapper;

import com.example.etudiants.dto.EtudiantDTO;
import com.example.etudiants.entity.Etudiant;
import org.springframework.stereotype.Component;

@Component
public class EtudiantMapper {

    public EtudiantDTO toDTO(Etudiant e) {
        return EtudiantDTO.builder()
                .id(e.getId())
                .cin(e.getCin())
                .nom(e.getNom())
                .dateNaissance(e.getDateNaissance())
                .email(e.getEmail())
                .anneePremiereInscription(e.getAnneePremiereInscription())
                .departementId(e.getDepartement() != null ? e.getDepartement().getId() : null)
                .departementNom(e.getDepartement() != null ? e.getDepartement().getNom() : null)
                .age(e.age())
                .build();
    }

    public Etudiant toEntity(EtudiantDTO dto) {
        Etudiant e = new Etudiant();
        e.setCin(dto.getCin());
        e.setNom(dto.getNom());
        e.setDateNaissance(dto.getDateNaissance());
        e.setEmail(dto.getEmail());
        e.setAnneePremiereInscription(dto.getAnneePremiereInscription());
        return e;
    }
}