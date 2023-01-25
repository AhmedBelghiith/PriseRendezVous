package com.example.prisesrdv.service;

import com.example.prisesrdv.entities.*;

import java.util.List;

public interface IService {
    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public Patient addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    public int getNbrRendezVousMedecin(Long idMedecin);
    public void retrieveRendezVous();


}
