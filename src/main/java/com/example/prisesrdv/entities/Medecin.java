package com.example.prisesrdv.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Medecin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String nomMedecin;
    private int telephone;
    private int prixConsultation;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @JsonIgnore
    @ManyToMany(mappedBy = "medecins")
    List<Clinique> cliniques;
}
