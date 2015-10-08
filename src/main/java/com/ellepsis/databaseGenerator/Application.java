package com.ellepsis.databaseGenerator;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientType;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import com.ellepsis.databaseGenerator.Repository.ClientTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by vladislav on 30.09.15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired private ClientRepository clientRepository;
    @Autowired private ClientTypeRepository clientTypeRepository;
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        ClientType firstType = new ClientType();
        firstType.setDescription("first client");
        firstType.setDiscount(100);

        clientTypeRepository.save(firstType);

        Client firstClient = new Client();
        firstClient.setFirstName("Ilya");
        firstClient.setSecondName("Mihaylov");
        firstClient.setMiddleName("Eduardovich");
        firstClient.setClientType(firstType);

        clientRepository.save(firstClient);

    }

    public void generateFemaleClients() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.mockaroo.com/d8c06b60/download?count=1000&key=bfda25a0");
        Client[] clients = restTemplate.getForObject(uri, Client[].class);
        for(Client client : clients)
    }
}
