package ma.enset.examjee.mapers;

import ma.enset.examjee.DTOs.ClientDTO;
import ma.enset.examjee.entities.Client;
import org.springframework.beans.BeanUtils;

public class ClientMapper {
    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }
    public Client fromClientDTO(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }


}
