package ma.enset.examjee.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContratDTO {
    private Long id;
    private Date dateSouscription;
    private String statut;
    private double montantCotisation;
    private int dureeContrat;
    private Long clientId;
}