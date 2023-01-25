package com.example.prisesrdv.repository;

import com.example.prisesrdv.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}