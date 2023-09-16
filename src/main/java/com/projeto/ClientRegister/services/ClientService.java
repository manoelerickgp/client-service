package com.projeto.ClientRegister.services;

import com.projeto.ClientRegister.entities.Client;
import com.projeto.ClientRegister.repositories.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id);
    }

    public Client insert(Client client) {
        client.setId(ThreadLocalRandom.current().nextLong(0, 1000));
        repository.save(client);
        return client;
    }

    public Client update(Long id, Client client) {
        client.setId(ThreadLocalRandom.current().nextLong(0, 1000));
        repository.update(client, id);
        return client;
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
