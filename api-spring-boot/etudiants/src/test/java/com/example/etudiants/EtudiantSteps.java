package com.example.etudiants;

import com.example.etudiants.entity.Etudiant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtudiantSteps {

    private Etudiant etudiant;
    private int age;

    @Given("un étudiant avec la date de naissance {string}")
    public void unEtudiantAvecLaDateDeNaissance(String date) {
        etudiant = new Etudiant(null, "12345678", "Test",
                LocalDate.parse(date), "test@email.com", 2020, null);
    }

    @When("on calcule son âge")
    public void onCalculeSonAge() {
        age = etudiant.age();
    }

    @Then("l'âge retourné doit être {int}")
    public void lAgeRetourneDoitEtre(int ageAttendu) {
        assertEquals(ageAttendu, age);
    }
}