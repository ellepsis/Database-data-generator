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
import java.util.List;
import java.util.Random;

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


}
