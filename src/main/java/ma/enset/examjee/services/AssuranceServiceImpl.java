package ma.enset.examjee.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.examjee.DTOs.*;
import ma.enset.examjee.entities.*;
import ma.enset.examjee.enums.StatutContrat;
import ma.enset.examjee.enums.TypePaiement;
import ma.enset.examjee.mapers.AssuranceMapper;
import ma.enset.examjee.mapers.ClientMapper;
import ma.enset.examjee.mapers.PaimentMapper;
import ma.enset.examjee.repositories.ClientRepository;
import ma.enset.examjee.repositories.ContratRepository;
import ma.enset.examjee.repositories.PaiementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class AssuranceServiceImpl implements IAssuranceService {

    private ClientRepository clientRepo;
    private ContratRepository contratRepo;
    private PaiementRepository paiementRepo;
    private AssuranceMapper mapper;
    private ClientMapper clientMapper;
    private PaimentMapper paiementMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepo.save(client);
        return clientMapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepo.findAll()
                .stream()
                .map(clientMapper::fromClient)
                .toList();
    }

    @Override
    public ContratAutoDTO souscrireContratAuto(ContratAutoDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratAutomobile contrat = new ContratAutomobile();
        BeanUtils.copyProperties(dto, contrat);
        contrat.setClient(client);
        contrat.setStatut(StatutContrat.EN_COURS);
        contrat.setDateSouscription(new Date());
        ContratAutomobile savedContrat = contratRepo.save(contrat);
        return mapper.fromContratAuto(savedContrat);
    }

    @Override
    public ContratHabitationDTO souscrireContratHab(ContratHabitationDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratHabitation contrat = new ContratHabitation();
        BeanUtils.copyProperties(dto, contrat);
        contrat.setClient(client);
        contrat.setStatut(StatutContrat.EN_COURS);
        contrat.setDateSouscription(new Date());
        ContratHabitation savedContrat = contratRepo.save(contrat);
        return mapper.fromContratHabit(savedContrat);
    }

    @Override
    public ContratSanteDTO souscrireContratSante(ContratSanteDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratSante contrat = new ContratSante();
        BeanUtils.copyProperties(dto, contrat);
        contrat.setClient(client);
        contrat.setStatut(StatutContrat.EN_COURS);
        contrat.setDateSouscription(new Date());
        ContratSante savedContrat = contratRepo.save(contrat);
        return mapper.fromContratSante(savedContrat);
    }

    @Override
    public void validerContrat(Long contratId) {
        Contrat contrat = contratRepo.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
        contrat.setStatut(StatutContrat.VALIDE);
        contrat.setDateValidation(new Date());
        contratRepo.save(contrat);
    }

    @Override
    public void resilierContrat(Long contratId) {
        Contrat contrat = contratRepo.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
        contrat.setStatut(StatutContrat.RESILIE);
        contratRepo.save(contrat);
    }

    @Override
    public List<ContratDTO> getContratsByClient(Long clientId) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        return client.getContrats()
                .stream()
                .map(c -> {
                    if (c instanceof ContratAutomobile) {
                        return mapper.fromContratAuto((ContratAutomobile) c);
                    } else if (c instanceof ContratHabitation) {
                        return mapper.fromContratHab((ContratHabitation) c);
                    } else if (c instanceof ContratSante) {
                        return mapper.fromContratSante((ContratSante) c);
                    }
                    return null;
                })
                .toList();
    }

    @Override
    public PaiementDTO effectuerPaiement(Long contratId, double montant, String type) {
        Contrat contrat = contratRepo.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
        Paiement paiement = new Paiement();
        paiement.setDatePaiement(new Date());
        paiement.setMontant(montant);
        paiement.setType(TypePaiement.valueOf(type));
        paiement.setContrat(contrat);
        return paiementMapper.fromPaiement(paiementRepo.save(paiement));
    }

    @Override
    public List<PaiementDTO> consulterHistoriquePaiements(Long contratId) {
        Contrat contrat = contratRepo.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));
        return contrat.getPaiements()
                .stream()
                .map(paiementMapper::fromPaiement)
                .toList();
    }
}