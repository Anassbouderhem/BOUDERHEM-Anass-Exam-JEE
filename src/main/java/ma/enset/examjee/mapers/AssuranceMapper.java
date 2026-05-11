package ma.enset.examjee.mapers;

import ma.enset.examjee.DTOs.ClientDTO;
import ma.enset.examjee.DTOs.ContratAutoDTO;
import ma.enset.examjee.DTOs.ContratSanteDTO;
import ma.enset.examjee.entities.Client;
import ma.enset.examjee.entities.ContratAutomobile;
import ma.enset.examjee.entities.ContratSante;
import ma.enset.examjee.enums.StatutContrat;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AssuranceMapper {
    public ContratAutoDTO fromContratAuto(ContratAutomobile contrat) {
        ContratAutoDTO dto = new ContratAutoDTO();
        BeanUtils.copyProperties(contrat, dto);
        dto.setClientId(contrat.getClient().getId());
        dto.setStatut(contrat.getStatut().name());
        return dto;
    }
    public ContratSanteDTO fromContratSante(ContratSante contrat) {
        ContratSanteDTO dto = new ContratSanteDTO();
        BeanUtils.copyProperties(contrat, dto);
        dto.setClientId(contrat.getClient().getId());
        dto.setStatut(contrat.getStatut().name());
        return dto;
    }

    public ContratSante fromContratSanteDTO(ContratSanteDTO dto) {
        ContratSante contrat = new ContratSante();
        BeanUtils.copyProperties(dto, contrat);
        contrat.setStatut(StatutContrat.valueOf(dto.getStatut()));
        return contrat;
    }

    public ContratAutomobile fromContratAutoDTO(ContratAutoDTO dto) {
        ContratAutomobile contrat = new ContratAutomobile();
        BeanUtils.copyProperties(dto, contrat);
        if (dto.getStatut() != null) {
            contrat.setStatut(StatutContrat.valueOf(dto.getStatut()));
        }

        return contrat;
    }

}