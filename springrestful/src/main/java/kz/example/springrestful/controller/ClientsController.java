package kz.example.springrestful.controller;

import kz.example.springrestful.entity.Client;
import kz.example.springrestful.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity addClient(@RequestBody Client client){
        return new ResponseEntity(clientService.addClient(client), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Client> getClientAll(){
        return clientService.getClientAll();
    }

    @GetMapping
    public ResponseEntity getClientById(@RequestParam Long id) {
        return new ResponseEntity(clientService.getClientById(id), HttpStatus.OK);
    }

    @GetMapping("/iin")
    public ResponseEntity getClientByIin(@RequestParam String iin){
        return new ResponseEntity(clientService.getClientByIin(iin), HttpStatus.OK);
    }
}
