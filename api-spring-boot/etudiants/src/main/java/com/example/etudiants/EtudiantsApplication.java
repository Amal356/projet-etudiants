package com.example.etudiants;

import com.example.etudiants.entity.Departement;
import com.example.etudiants.entity.Etudiant;
import com.example.etudiants.repository.DepartementRepository;
import com.example.etudiants.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class EtudiantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantsApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(EtudiantRepository etudiantRepo,
							   DepartementRepository departementRepo) {
		return args -> {
			Departement info = departementRepo.save(new Departement(null, "Informatique"));
			Departement math = departementRepo.save(new Departement(null, "Mathématiques"));

			etudiantRepo.save(new Etudiant(null, "12345678", "Ahmed Ben Ali",
					LocalDate.of(2000, 1, 15), "ahmed@email.com", 2020, info));
			etudiantRepo.save(new Etudiant(null, "23456789", "Fatma Trabelsi",
					LocalDate.of(1999, 5, 20), "fatma@email.com", 2019, math));
			etudiantRepo.save(new Etudiant(null, "34567890", "Mohamed Sassi",
					LocalDate.of(2001, 3, 10), "mohamed@email.com", 2021, info));
			etudiantRepo.save(new Etudiant(null, "45678901", "Sarra Mejri",
					LocalDate.of(2000, 7, 25), "sarra@email.com", 2020, math));
			etudiantRepo.save(new Etudiant(null, "56789012", "Youssef Hamdi",
					LocalDate.of(1998, 11, 5), "youssef@email.com", 2018, info));
		};
	}
}