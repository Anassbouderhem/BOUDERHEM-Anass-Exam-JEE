package ma.enset.examjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("AUTOMOBILE")
@Data @NoArgsConstructor @AllArgsConstructor
public class ContratAutomobile extends Contrat {
    private String matricule;
    private String marque;
    private String modele;
}