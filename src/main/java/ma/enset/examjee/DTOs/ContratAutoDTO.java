package ma.enset.examjee.DTOs;

import lombok.Data;

@Data
public class ContratAutoDTO extends ContratDTO {
    private String matricule;
    private String marque;
    private String modele;
}