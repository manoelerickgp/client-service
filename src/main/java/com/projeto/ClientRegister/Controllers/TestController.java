package com.projeto.ClientRegister.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String testando(){
        return "Testando requisição.";
    }
}
