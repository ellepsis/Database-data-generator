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

    public List<ClientType> generateClientType() {
        ClientType clientType1 = new ClientType();
        clientType1.setDescription("regular");
        clientType1.setDiscount(10);

        ClientType clientType2 = new ClientType();
        clientType2.setDescription("special");
        clientType2.setDiscount(20);

        ClientType clientType3 = new ClientType();
        clientType3.setDescription("new");
        clientType3.setDiscount(0);

        ClientType clientType4 = new ClientType();
        clientType4.setDescription("free");
        clientType4.setDiscount(100);

        return Arrays.asList(
                clientType1,
                clientType2,
                clientType3,
                clientType4
        );
    }

    public List<Client> generateClients(ClientTypeRepository clientTypeRepository, int count ) throws Exception {
        List<ClientType> clientTypes = clientTypeRepository.findAll();
        clientTypes.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        List<Client> allClients = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Client[] maleClients = generateMaleClients(clientTypes);
            Client[] femaleClients = generateFemaleClients(clientTypes);
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
        return allClients;
    }

    private Client[] generateFemaleClients(List<ClientType> clientTypes) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.mockaroo.com/d8c06b60/download?count=1000&key=bfda25a0");
        Client[] clients = restTemplate.getForObject(uri, Client[].class);
        for (Client client : clients) {
            if (client.getMiddleName() != null)
                client.setMiddleName(client.getMiddleName().concat("ovna"));
            client.setGender('F');
            client.setClientType(getRandomClientType(clientTypes));
        }
        return clients;
    }

    private Client[] generateMaleClients(List<ClientType> clientTypes) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.mockaroo.com/b4fd3550/download?count=1000&key=bfda25a0");
        Client[] clients = restTemplate.getForObject(uri, Client[].class);
        for (Client client : clients) {
            if (client.getMiddleName() != null)
                client.setMiddleName(client.getMiddleName().concat("ovich"));
            client.setGender('M');
            client.setClientType(getRandomClientType(clientTypes));
        }
        return clients;
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
