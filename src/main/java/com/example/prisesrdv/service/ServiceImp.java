package com.example.prisesrdv.service;


import com.example.prisesrdv.entities.*;
import com.example.prisesrdv.repository.CliniqueRepository;
import com.example.prisesrdv.repository.MedecinRepository;
import com.example.prisesrdv.repository.PatientRepository;
import com.example.prisesrdv.repository.RendezVousRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceImp implements IService{

    CliniqueRepository cliniqueRepository;
    MedecinRepository medecinRepository;
    PatientRepository patientRepository;
    RendezVousRepository rendezVousRepository;


    @Override
    public Clinique addClinique(Clinique clinique) {
        return this.cliniqueRepository.save(clinique);
    }

    @Override
    @Transactional
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long idClinique) {
        Clinique clinique = this.cliniqueRepository.findById(idClinique).orElse(null);
        clinique.getMedecins().add(medecin);
        return this.medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin = this.medecinRepository.findById(idMedecin).orElse(null);
        Patient patient = this.patientRepository.findById(idPatient).orElse(null);
        rdv.setMedecin(medecin);
        rdv.setPatient(patient);
        this.rendezVousRepository.save(rdv);

    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return this.rendezVousRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique,specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin medecin = this.medecinRepository.findById(idMedecin).orElse(null);
        medecin.getRendezVousList();

        return medecin.getRendezVousList().size();
    }

    @Override
    @Scheduled(cron = "* */15 * * * *")
    public void retrieveRendezVous() {
        List<RendezVous> rendezVousList = this.rendezVousRepository.findAll();
        for (RendezVous rdv : rendezVousList){
            if (rdv.getDateRdv().after(new Date()))
                log.info("La liste des RendezVous : " + rdv.getDateRdv() + " : Medecin :"
                        + rdv.getMedecin().getNomMedecin() + " : Patient :"
                        + rdv.getPatient().getNomPatient());

        }

    }
}
