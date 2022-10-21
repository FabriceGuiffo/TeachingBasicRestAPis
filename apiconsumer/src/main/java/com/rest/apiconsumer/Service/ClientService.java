package com.rest.apiconsumer.Service;

import com.rest.apiconsumer.DAL.ClientProxy;
import com.rest.apiconsumer.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ClientService {

    @Autowired
    private ClientProxy clientProxy;

    //method to return all clients with a capital name
    public List<Client> tousLesClients(){
        List<Client> presentClients= clientProxy.getAllClient();
        /*for (int i=0;i< presentClients.size();i++){
            Client client= presentClients.get(i);
            client.setName(client.getName().toUpperCase());
            client.getChristianName().toLowerCase(Locale.ROOT);
            presentClients.set(i,client);
            System.out.println(i);
        }*/
        for (Client client:presentClients){
            client.setName(client.getName().toUpperCase());
            client.setChristianName(client.getChristianName().toLowerCase());
        }

        return presentClients;
    }

    //method to return a particular client
    public Client aClient(int id){
        return clientProxy.getAClient(id);
    }

    //method to add a new client
    public String newClient(Client nw){
        return clientProxy.addClient(nw);
    }

    //method to delete a client
    public void removeClient(Integer id){
        clientProxy.deleteClient(id);
    }
}
