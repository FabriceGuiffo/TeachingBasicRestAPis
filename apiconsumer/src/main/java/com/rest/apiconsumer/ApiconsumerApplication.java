package com.rest.apiconsumer;

import com.rest.apiconsumer.Configuration.ConfigProps;
import com.rest.apiconsumer.Controller.ClientController;
import com.rest.apiconsumer.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiconsumerApplication implements CommandLineRunner {

	@Autowired
	ClientController clientController;



	public static void main(String[] args) {
		SpringApplication.run(ApiconsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*List<Client> clients = clientController.allClients();
		for (Client client:clients){
			System.out.println(client.toString());
		}*/

		//renvoi un seul client
		//System.out.println(clientController.oneClient(2).toString());

		//ajoute un client a la BDD et retourne son uri
		/*Client newclient = new Client("Guiffo","Fabrice",30,"fabphil16@yahoo.fr");
		String createdURI=clientController.createClient(newclient);
		System.out.println(createdURI);*/

		//delete client
		clientController.deleteClient(2);

	}
}
