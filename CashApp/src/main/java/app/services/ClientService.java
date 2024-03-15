package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import app.repositories.ClientRepository;

public class ClientService {
    
    @Autowired 
    private ClientRepository clientRepository;

    public void insertClient(Client client){
        clientRepository.save(client);
    }

}