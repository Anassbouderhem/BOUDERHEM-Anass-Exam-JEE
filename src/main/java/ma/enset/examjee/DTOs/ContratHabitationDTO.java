package ma.enset.examjee.DTOs;

import lombok.Data;

@Data
public class ContratHabitationDTO extends ContratDTO {
    private String adresse;
    private double superficie;
}
