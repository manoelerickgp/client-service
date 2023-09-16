package com.projeto.ClientRegister.repositories;

import com.projeto.ClientRegister.entities.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClientRepository {

    Map<Long, Client> map = new HashMap<>();

    public List<Client> findAll(){
        return new ArrayList<Client>(map.values());
    }

    public Client findById(Long id) {
        return map.get(id);
    }

    public void save(Client obj) {
        map.put(obj.getId(), obj);
    }

    public Client update(Client newObj, Long id) {
        map.remove(id);
        return map.put(newObj.getId(), newObj);
    }

    public void delete(Long id){
        map.remove(id);
    }
}
