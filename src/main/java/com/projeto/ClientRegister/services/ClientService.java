package com.projeto.ClientRegister.services;

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

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Found"));
    }

    public Client insert(Client client) {
        return repository.save(client);
    }

    public Client update(Long id, Client clientToBeUpdated) {
        Client clientSaved = findById(id);
        updateClient(clientSaved, clientToBeUpdated);
        return repository.save(clientSaved);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    private void updateClient(Client clientSaved, Client clientToBeUpdated) {
        clientSaved.setName(clientToBeUpdated.getName());
        clientSaved.setCpf(clientToBeUpdated.getCpf());
        clientSaved.setIncome(clientToBeUpdated.getIncome());
        clientSaved.setBirthDate(clientToBeUpdated.getBirthDate());
        clientSaved.setChildren(clientToBeUpdated.getChildren());
    }
}
