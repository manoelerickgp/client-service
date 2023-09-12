package com.projeto.ClientRegister.Controllers;

import com.projeto.ClientRegister.entities.Client;
import com.projeto.ClientRegister.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
