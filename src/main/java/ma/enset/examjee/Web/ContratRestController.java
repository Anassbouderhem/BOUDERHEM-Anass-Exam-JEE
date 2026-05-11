package ma.enset.examjee.Web;

import lombok.AllArgsConstructor;
import ma.enset.examjee.DTOs.ContratAutoDTO;
import ma.enset.examjee.DTOs.ContratDTO;
import ma.enset.examjee.DTOs.PaiementDTO;
import ma.enset.examjee.services.IAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class ContratRestController {
    private IAssuranceService assuranceService;

    @PostMapping("/contrats/auto")
    public ContratAutoDTO saveContratAuto(@RequestBody ContratAutoDTO contratAutoDTO) {
        return assuranceService.souscrireContratAuto(contratAutoDTO);
    }

    @GetMapping("/clients/{clientId}/contrats")
    public List<ContratDTO> getContratsByClient(@PathVariable Long clientId) {
        return assuranceService.getContratsByClient(clientId);
    }

    @PutMapping("/contrats/{id}/valider")
    public void valider(@PathVariable Long id) {
        assuranceService.validerContrat(id);
    }

    @PutMapping("/contrats/{id}/resilier")
    public void resilier(@PathVariable Long id) {
        assuranceService.resilierContrat(id);
    }

    @PostMapping("/contrats/{id}/paiements")
    public PaiementDTO payer(@PathVariable Long id,
                             @RequestParam double montant,
                             @RequestParam String type) {
        return assuranceService.effectuerPaiement(id, montant, type);
    }

    @GetMapping("/contrats/{id}/paiements")
    public List<PaiementDTO> getHistorique(@PathVariable Long id) {
        return assuranceService.consulterHistoriquePaiements(id);
    }
}