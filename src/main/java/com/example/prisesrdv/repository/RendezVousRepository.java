package com.example.prisesrdv.repository;

import com.example.prisesrdv.entities.RendezVous;
import com.example.prisesrdv.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{
    List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(Long idClinique, Specialite specialite);
}