package com.projeto.ClientRegister.Controllers;

import com.projeto.ClientRegister.entities.Client;
import com.projeto.ClientRegister.services.ClientService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientResource {

    private ClientService service;

    public ClientResource(ClientService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        client = service.insert(client);
        return ResponseEntity.ok().body(client);
    }


}
