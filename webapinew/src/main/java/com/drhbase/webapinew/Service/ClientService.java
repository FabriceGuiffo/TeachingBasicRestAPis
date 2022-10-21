package com.drhbase.webapinew.Service;

import com.drhbase.webapinew.DAL.ClientRepository;
import com.drhbase.webapinew.Model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //get all users
    public Iterable<Client> listeTousLesClients(){
        return clientRepository.findAll();
    }

    //get user by id
    public Optional<Client> listeUnClient(int id){
        return clientRepository.findById(id);
    }

    //create new user
    public Client ajouterClient(Client client){
        return clientRepository.save(client);
    }

    //delete client by id
    public void supprimerClient(int id){
        clientRepository.deleteById(id);
    }

}