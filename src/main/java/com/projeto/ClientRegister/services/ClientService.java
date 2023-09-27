package com.projeto.ClientRegister.services;

import com.projeto.ClientRegister.DTO.ClientDTO;
import com.projeto.ClientRegister.entities.Client;
import com.projeto.ClientRegister.repositories.ClientRepository;
import com.projeto.ClientRegister.services.exceptions.ClientDatabaseException;
import com.projeto.ClientRegister.services.exceptions.ClientNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new ClientNotFound("Client Not Found"));
        return new ClientDTO(client);
    }

    public ClientDTO insert(ClientDTO clientDtoToBeSaved) {
        Client clientSaved = new Client();
        copyDtoToEntity(clientSaved, clientDtoToBeSaved);
        clientSaved = repository.save(clientSaved);
        return new ClientDTO(clientSaved);
    }

    public ClientDTO update(Long id, ClientDTO clientToBeUpdated) {
        try {
            Client clientSaved = repository.getReferenceById(id);
            copyDtoToEntity(clientSaved, clientToBeUpdated);
            clientSaved = repository.save(clientSaved);
            return new ClientDTO(clientSaved);
        }
        catch (EntityNotFoundException e) {
            throw new ClientNotFound("Client Not Found");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ClientNotFound("Client Not Found");
        }
        catch (DataIntegrityViolationException e) {
            throw new ClientDatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(Client clientSaved, ClientDTO clientToBeUpdated) {
        clientSaved.setName(clientToBeUpdated.getName());
        clientSaved.setCpf(clientToBeUpdated.getCpf());
        clientSaved.setIncome(clientToBeUpdated.getIncome());
        clientSaved.setBirthDate(clientToBeUpdated.getBirthDate());
        clientSaved.setChildren(clientToBeUpdated.getChildren());
    }
}
