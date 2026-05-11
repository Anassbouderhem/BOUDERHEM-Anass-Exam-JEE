package ma.enset.examjee.services;

import ma.enset.examjee.DTOs.ClientDTO;
import ma.enset.examjee.DTOs.ContratAutoDTO;
import ma.enset.examjee.DTOs.ContratDTO;
import ma.enset.examjee.DTOs.PaiementDTO;

import java.util.List;

public interface IAssuranceService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();

    ContratAutoDTO souscrireContratAuto(ContratAutoDTO dto);
    void validerContrat(Long contratId);
    void resilierContrat(Long contratId);
    List<ContratDTO> getContratsByClient(Long clientId);

    PaiementDTO effectuerPaiement(Long contratId, double montant, String type);
    List<PaiementDTO> consulterHistoriquePaiements(Long contratId);
}
