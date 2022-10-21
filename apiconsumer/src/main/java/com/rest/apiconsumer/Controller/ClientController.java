package com.rest.apiconsumer.Controller;

import com.rest.apiconsumer.Model.Client;
import com.rest.apiconsumer.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    //show all clients
    public List<Client> allClients(){
        return clientService.tousLesClients();
    }

    //show a particular client
    public Client oneClient(int id){
        return clientService.aClient(id);
    }

    //add new client
    public String createClient(Client nw){
        return clientService.newClient(nw);
    }

   //delete client
    public void deleteClient(Integer id){
        clientService.removeClient(id);
    }


}
