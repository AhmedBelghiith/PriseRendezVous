package com.example.prisesrdv.controller;

import com.example.prisesrdv.entities.*;
import com.example.prisesrdv.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    IService iService;

    @PostMapping("/addClinique")
    public Clinique addClinique (@RequestBody Clinique clinique) {
        return iService.addClinique(clinique);
    }

    @PostMapping("/addMedecinAndAssignToClinique/{idClinique}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin,@PathVariable("idClinique") Long idClinique) {
        return this.iService.addMedecinAndAssignToClinique(medecin,idClinique);
    }

    @PostMapping("/addPatient")
    public Patient addPatient (@RequestBody Patient patient) {
        return iService.addPatient(patient);
    }

    @PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable("idMedecin") Long idMedecin,
                                             @PathVariable("idPatient") Long idPatient) {
        iService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }

    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("idClinique") Long idClinique,@PathVariable("specialite") Specialite specialite) {
        return this.iService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }

    @GetMapping("/getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable("idMedecin") Long idMedecin) {
        return this.iService.getNbrRendezVousMedecin(idMedecin);
    }

}
