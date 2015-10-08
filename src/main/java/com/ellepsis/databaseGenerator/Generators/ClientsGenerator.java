package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientType;
import com.ellepsis.databaseGenerator.Repository.ClientTypeRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public class ClientsGenerator {

    Random random = new Random();

    public void generateFemaleClients(ClientTypeRepository clientTypeRepository) throws URISyntaxException {
        List<ClientType> clientTypes = clientTypeRepository.findAll();
        clientTypes.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.mockaroo.com/d8c06b60/download?count=1000&key=bfda25a0");
        Client[] clients = restTemplate.getForObject(uri, Client[].class);
        for(Client client : clients){
            if (client.getMiddleName() != null)
                client.setMiddleName(client.getMiddleName().concat("ovna"));
            client.setGender('F');
            int rnum = random.nextInt(10);

            if (rnum<1) {
                client.setClientType(clientTypes.get(0));
                continue;
            }
            if (rnum<5) {
                client.setClientType(clientTypes.get(1));
                continue;
            }
            if (rnum<7){
                client.setClientType(clientTypes.get(2));
                continue;
            }
            else {
                client.setClientType(clientTypes.get(3));
                continue;
            }
        }
    }
}
