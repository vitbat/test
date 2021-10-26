package kz.example.springrestful.service;

import kz.example.springrestful.entity.Client;
import kz.example.springrestful.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getClientAll(){
        List<Client> clientList = new ArrayList<>();
        clientRepo.findAll().forEach(clientList::add);
        return clientList;
    }

    public Client addClient(Client client){
        client = clientRepo.save(client);
        return client;
    }

    public Client getClientById(Long id){
        Client client = clientRepo.findById(id).get();
        return client;
    }

    public Client getClientByIin(String iin){
        Client client = clientRepo.findByIin(iin);
        return client;
    }
}
