package com.projeto.ClientRegister.config;

import com.projeto.ClientRegister.entities.Client;
import com.projeto.ClientRegister.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class TestConfig implements CommandLineRunner {

    private final ClientRepository repository;

    public TestConfig(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        Client c1 = new Client(1L, "Bob Bronw", "111.222.333-44", 3000.0, Instant.parse("1994-07-20T10:30:00Z"), 1);
        Client c2 = new Client(2L, "Mary Green", "123.543.437-32", 4000.0, Instant.parse("1997-02-13T09:50:00Z"), 1);
        Client c3 = new Client(3L, "Alex White", "378.234.347-89", 5000.0, Instant.parse("1998-06-23T11:13:00Z"), 0);

        repository.save(c1);
        repository.save(c2);
        repository.save(c3);*/
    }
}
