package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientType;
import com.ellepsis.databaseGenerator.Repository.ClientTypeRepository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public class ClientsGenerator {

    Random random = new Random();

    public List<Client> generateClients(ClientTypeRepository clientTypeRepository, int count ) throws Exception {
        List<Client> allClients = new ArrayList<>(count);
        for (int i = 0; i < count/2; i++) {
            Client[] maleClients = generateMaleClients();
            Client[] femaleClients = generateFemaleClients();
            int maleClientNumber = 0;
            int femaleClientNumber = 0;
            while(maleClientNumber < maleClients.length && femaleClientNumber < maleClients.length) {
                if (random.nextInt(10) > 4) { //Male
                    if (maleClientNumber < maleClients.length)
                        allClients.add(maleClients[maleClientNumber++]);
                } else {                      //female
                    if (femaleClientNumber < femaleClients.length)
                        allClients.add(femaleClients[femaleClientNumber++]);
                }
            }
        }
        listRepair(allClients, clientTypeRepository);
        return allClients;
    }

    private Client[] generateFemaleClients() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.mockaroo.com/d8c06b60/download?count=1000&key=bfda25a0");
        Client[] clients = restTemplate.getForObject(uri, Client[].class);
        for (Client client : clients) {
            if (client.getMiddleName() != null)
                client.setMiddleName(client.getMiddleName().concat("ovna"));
            client.setGender('F');
        }
        return clients;
    }

    private Client[] generateMaleClients() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.mockaroo.com/b4fd3550/download?count=1000&key=bfda25a0");
        Client[] clients = restTemplate.getForObject(uri, Client[].class);
        for (Client client : clients) {
            if (client.getMiddleName() != null)
                client.setMiddleName(client.getMiddleName().concat("ovich"));
            client.setGender('M');
        }
        return clients;
    }

    public void listRepair(List<Client> clients, ClientTypeRepository clientTypeRepository){
        List<ClientType> clientTypes = clientTypeRepository.findAll();
        clients.stream().forEach(o -> o.setClientType(getRandomClientType(clientTypes)));
    }

    private ClientType getRandomClientType(List<ClientType> clientTypes){
        int rNum = random.nextInt(10);
        if (rNum < 1) {
            return clientTypes.get(0);
        }
        if (rNum < 5) {
            return clientTypes.get(1);
        }
        if (rNum < 7) {
            return clientTypes.get(2);
        } else {
            return clientTypes.get(3);
        }
    }
}
