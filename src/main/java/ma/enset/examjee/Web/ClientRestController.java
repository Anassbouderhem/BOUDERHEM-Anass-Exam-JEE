package ma.enset.examjee.Web;

import lombok.AllArgsConstructor;
import ma.enset.examjee.DTOs.ClientDTO;
import ma.enset.examjee.services.IAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientRestController {
    private IAssuranceService assuranceService;

    @GetMapping
    public List<ClientDTO> clients() {
        return assuranceService.listClients();
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return assuranceService.saveClient(clientDTO);
    }
}