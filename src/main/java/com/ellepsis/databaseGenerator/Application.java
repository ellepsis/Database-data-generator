package com.ellepsis.databaseGenerator;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Generators.ClientsGenerator;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import com.ellepsis.databaseGenerator.Repository.ClientTypeRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
       //addClients();
    }

    private void addClients() throws IOException {
        ClientsGenerator clientsGenerator = new ClientsGenerator();
        clientTypeRepository.save(clientsGenerator.generateClientType());
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType clientListType = mapper.getTypeFactory().constructCollectionType(List.class, Client.class);
        File file = new File("D:\\DatabaseGenerator\\jsonGeneratedFiles\\Clients.json");
        List<Client> users = mapper.readValue(file, clientListType);
        clientRepository.save(users);
    }


}
