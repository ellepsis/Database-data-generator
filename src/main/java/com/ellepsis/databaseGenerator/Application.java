package com.ellepsis.databaseGenerator;

import com.ellepsis.databaseGenerator.Generators.ClientsGenerator;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import com.ellepsis.databaseGenerator.Repository.ClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        ClientsGenerator clientsGenerator = new ClientsGenerator();
        clientTypeRepository.save(clientsGenerator.generateClientType());
        clientRepository.save(clientsGenerator.generateClients(clientTypeRepository, 6));
    }


}
