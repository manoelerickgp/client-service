package com.projeto.ClientRegister.services;

import com.projeto.ClientRegister.DTO.ClientDTO;
import com.projeto.ClientRegister.entities.Client;
import com.projeto.ClientRegister.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientDTO> findAll(){
        List<Client> list = repository.findAll();
        return list.stream().map(c -> new ClientDTO(c)).toList();
    }

    public ClientDTO findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Found"));
        return new ClientDTO(client);
    }

    public ClientDTO insert(ClientDTO clientDtoToBeSaved) {
        Client clientSaved = new Client();
        copyClientDtoToEntity(clientSaved, clientDtoToBeSaved);
        clientSaved = repository.save(clientSaved);
        return new ClientDTO(clientSaved);
    }

    public ClientDTO update(Long id, ClientDTO clientToBeUpdated) {
        Client clientSaved = repository.getReferenceById(id);
        copyClientDtoToEntity(clientSaved, clientToBeUpdated);
        clientSaved = repository.save(clientSaved);
        return new ClientDTO(clientSaved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copyClientDtoToEntity(Client clientSaved, ClientDTO clientToBeUpdated) {
        clientSaved.setName(clientToBeUpdated.getName());
        clientSaved.setCpf(clientToBeUpdated.getCpf());
        clientSaved.setIncome(clientToBeUpdated.getIncome());
        clientSaved.setBirthDate(clientToBeUpdated.getBirthDate());
        clientSaved.setChildren(clientToBeUpdated.getChildren());
    }
}
