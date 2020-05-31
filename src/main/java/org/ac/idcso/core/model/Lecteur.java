package org.ac.idcso.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

//Annotation lombok, génération de getters, setter, class builder, hash code différent...
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lecteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 4,max = 20)
    private String nom;
    @NotBlank
    @Length(min = 4,max = 20)
    private String prenom;
    private boolean genre;
    private LocalDate dateNaissance;
}
