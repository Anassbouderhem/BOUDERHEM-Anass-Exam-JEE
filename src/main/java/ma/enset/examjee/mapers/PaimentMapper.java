package ma.enset.examjee.mapers;

import ma.enset.examjee.DTOs.PaiementDTO;
import ma.enset.examjee.entities.Paiement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class PaimentMapper {

public PaiementDTO fromPaiement(Paiement paiement) {
    PaiementDTO dto = new PaiementDTO();
    BeanUtils.copyProperties(paiement, dto);
    dto.setContratId(paiement.getContrat().getId());
    return dto;
}

public Paiement fromPaiementDTO(PaiementDTO dto) {
    Paiement paiement = new Paiement();
    BeanUtils.copyProperties(dto, paiement);
    return paiement;
}

}
