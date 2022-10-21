package com.rest.apiconsumer.DAL;

import com.rest.apiconsumer.Configuration.ConfigProps;
import com.rest.apiconsumer.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClientProxy {

    @Autowired
    private ConfigProps configProps;


    /*get list of clients*/
    public List<Client> getAllClient(){
        String url=configProps.getBaseurl();
        RestTemplate httpclient = new RestTemplate();
        ResponseEntity<List<Client>> response=  httpclient.exchange(url+"/Clients",
                                                    HttpMethod.GET,
                                                    null,
                                                    new ParameterizedTypeReference<List<Client>>() {});

        return response.getBody();
    }

    /*get particular employee*/
    public Client getAClient(int id){
        String url=configProps.getBaseurl();
        RestTemplate httpclient = new RestTemplate();
        ResponseEntity<Client> response=  httpclient.exchange(url+"/Clients/"+id,
                HttpMethod.GET,
                null,
                Client.class);

        return response.getBody();
    }

    public String addClient(Client client){
        String url=configProps.getBaseurl();
        HttpEntity<Client> request = new HttpEntity<Client>(client);
        RestTemplate httpclient = new RestTemplate();
        URI newlocation = httpclient.postForLocation(url+"/Clients",request,Client.class);
        return newlocation.toString();
    }

    //delete client
    public void deleteClient(Integer id){
        String url=configProps.getBaseurl();
        String deleteurl=url+"/Clients/{id}";
        Map<String,Integer> params = new HashMap<String,Integer>();
        params.put("id",id);
        RestTemplate httpclient = new RestTemplate();
        httpclient.delete(deleteurl,params);
    }

}
