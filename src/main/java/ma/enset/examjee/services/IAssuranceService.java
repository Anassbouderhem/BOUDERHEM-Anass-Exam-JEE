package ma.enset.examjee.services;

import ma.enset.examjee.DTOs.*;

import java.util.List;

public interface IAssuranceService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();

    ContratAutoDTO souscrireContratAuto(ContratAutoDTO dto);

    ContratHabitationDTO souscrireContratHab(ContratHabitationDTO dto);

    ContratSanteDTO souscrireContratSante(ContratSanteDTO dto);

    void validerContrat(Long contratId);
    void resilierContrat(Long contratId);
    List<ContratDTO> getContratsByClient(Long clientId);

    PaiementDTO effectuerPaiement(Long contratId, double montant, String type);
    List<PaiementDTO> consulterHistoriquePaiements(Long contratId);
}
