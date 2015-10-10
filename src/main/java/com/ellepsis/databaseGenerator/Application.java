package com.ellepsis.databaseGenerator;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientPhone;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import com.ellepsis.databaseGenerator.Generators.AddressGenerator;
import com.ellepsis.databaseGenerator.Generators.AddressGenerator;
import com.ellepsis.databaseGenerator.Generators.ClientPhonesGenerator;
import com.ellepsis.databaseGenerator.Generators.ClientTypesGenerator;
import com.ellepsis.databaseGenerator.Generators.ClientsGenerator;
import com.ellepsis.databaseGenerator.Repository.ClientPhoneRepository;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import com.ellepsis.databaseGenerator.Repository.ClientTypeRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
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

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by vladislav on 30.09.15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired private ClientRepository clientRepository;
    @Autowired private ClientTypeRepository clientTypeRepository;
    @Autowired private ClientPhoneRepository clientPhoneRepository;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //addClients();
        //generateClientPhones();
        AddressGenerator asdf = new AddressGenerator("D:\\DatabaseGenerator\\jsonGeneratedFiles\\addresses.yml");
        System.out.println( asdf.generateAddress() );
    }

    private void addClients() throws IOException {
        ClientTypesGenerator clientTypesGenerator = new ClientTypesGenerator();
        clientTypeRepository.save(clientTypesGenerator.generateClientType());
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType clientListType = mapper.getTypeFactory().constructCollectionType(List.class, Client.class);
        File file = new File("D:\\DatabaseGenerator\\jsonGeneratedFiles\\Clients.json");
        List<Client> users = mapper.readValue(file, clientListType);
        clientRepository.save(users);
    }

    private void generateClientPhones() throws URISyntaxException, IOException {
        //ClientPhonesGenerator clientPhonesGenerator = new ClientPhonesGenerator();
        //List<ClientPhone> result = clientPhonesGenerator.generateClientPhones(clientRepository);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C:\\Users\\EllepsisRT\\Documents\\IdeaProjects\\DatabaseGenerator\\jsonGeneratedFiles\\ClientPhones.json");
        //mapper.writeValue(file, result);
        final CollectionType clientListType = mapper.getTypeFactory().constructCollectionType(List.class, ClientPhone.class);
        List<ClientPhone> clientPhones = mapper.readValue(file, clientListType);
        clientPhoneRepository.save(clientPhones);
    }
}
