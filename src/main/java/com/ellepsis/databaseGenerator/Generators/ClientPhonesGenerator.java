package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientPhone;
import com.ellepsis.databaseGenerator.Entity.ClientType;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class ClientPhonesGenerator{
    Random r = new Random();
    public List<ClientPhone> generateClientPhones(ClientRepository clientRepository) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        List<Client> clients = clientRepository.findAll();
        List<ClientPhone> clientPhones = new ArrayList<>();
        int clientsSize = clients.size();
        for (int i = 0; i < clientsSize/1000; i++){
            URI uri = new URI("https://mockaroo.com/74218160/download?count=1000&key=bfda25a0");
            ClientPhone[] clientPhonesArray = restTemplate.getForObject(uri, ClientPhone[].class);
            for(ClientPhone clientPhone : clientPhonesArray){
                clientPhone.setClientId(clients.get(r.nextInt(clientsSize-1)));
            }
            clientPhones.addAll(Arrays.asList(clientPhonesArray));
        }
        return clientPhones;
    }
}
