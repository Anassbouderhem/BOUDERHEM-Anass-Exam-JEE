package ma.enset.examjee.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class PaiementDTO {
    private Long id;
    private Date date;
    private double montant;
    private String type;
    private Long contratId;
}