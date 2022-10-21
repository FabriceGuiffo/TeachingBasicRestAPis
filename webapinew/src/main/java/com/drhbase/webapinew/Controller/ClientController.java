package com.drhbase.webapinew.Controller;

import com.drhbase.webapinew.DAL.ClientRepository;
import com.drhbase.webapinew.Model.Client;
import com.drhbase.webapinew.Service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Api("Api pour les op crud sur les clients")
@RestController
public class ClientController {

    @Autowired
    ClientService clientservice;
    /*@Autowired
    ClientRepository clientRepository;*/

    @GetMapping("/Clients")
    public List<Client> allClients(){
        List<Client> clients = new ArrayList<Client>();
        clientservice.listeTousLesClients().forEach(clients::add);
        return clients;
    }
    @ApiOperation(value="operation pour retourner un client en particulier")
    @GetMapping("/Clients/{id}")
    public Client oneClient(@PathVariable int id){
        return clientservice.listeUnClient(id).get();
    }

    @PostMapping("/Clients")
    public ResponseEntity<Client> addClient(@Valid @RequestBody Client newClient){
        Client savedClient = clientservice.ajouterClient(newClient);
        if (Objects.isNull(savedClient)){
            return ResponseEntity.noContent().build();
        }
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    /*@PostMapping("/Clients")
    public void addClient(@RequestBody Client newClient){
        Client savedClient=clientRepository.save(newClient);
    }*/

    @PutMapping("/Clients")
    public void updateClient(@Valid @RequestBody Client client){
        clientservice.ajouterClient(client);
    }

    @DeleteMapping("/Clients/{id}")
    public void deleteClient(@PathVariable("id") int id){
        clientservice.supprimerClient(id);
    }

}
