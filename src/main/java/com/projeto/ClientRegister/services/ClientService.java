package com.projeto.ClientRegister.services;

import com.projeto.ClientRegister.entities.Client;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ClientService {

    public static List<Client> clients;

    static {
        clients = new ArrayList<>(List.of(new Client(1L, "Bob Bronw", "111.222.333-44", 3000.0, Instant.parse("1994-07-20T10:30:00Z"), 1),
            new Client(2L, "Mary Green", "123.543.437-32", 4000.0, Instant.parse("1997-02-13T09:50:00Z"), 1),
            new Client(3L, "Alex White", "378.234.347-89", 5000.0, Instant.parse("1998-06-23T11:13:00Z"), 0)));
    }

    public List<Client> findAll(){
        return clients;
    }

    public Client findById(Long id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found"));
    }

    public Client insert(Client client) {
        client.setId(ThreadLocalRandom.current().nextLong(0, 1000));
        clients.add(client);
        return client;
    }

    public void update(Long id, Client client) {
        clients.remove(findById(id));
        insert(client);
    }
}
