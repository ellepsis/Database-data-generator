package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.*;
import com.ellepsis.databaseGenerator.Generators.AddressGenerator;
import com.ellepsis.databaseGenerator.Generators.ClientTypesGenerator;
import com.ellepsis.databaseGenerator.Repository.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.management.PersistentMBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
@Configuration
@ComponentScan("com.bd.service")
public class EveryThingGenerator {

    @Autowired private ClientRepository clientRepository;
    @Autowired private ClientTypeRepository clientTypeRepository;
    @Autowired private ClientPhoneRepository clientPhoneRepository;
    @Autowired private SystemUserRepository systemUserRepository;
    @Autowired private PermissionTypeRepository permissionTypeRepository;
    @Autowired private EmployeeRepository employeeRepository;

    public void generate() throws IOException, URISyntaxException {
        //addClients();
        //generateClientPhones();
        //generateEmployeesAndAllWithIt(500);
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

    private void generateEmployeesAndAllWithIt(int count) throws URISyntaxException, IOException {
        //generatePermissions();
        //generateSystemUsers(count);
        //generateEmployees(count);
    }

    private void generatePermissions() {
        PermissionTypeGenerator permissionTypeGenerator = new PermissionTypeGenerator();
        List<PermissionType> permissionTypes = permissionTypeGenerator.generatePermissionTypes();
        permissionTypeRepository.save(permissionTypes);
    }

    private void generateSystemUsers(int count) throws URISyntaxException, IOException {
        //List<SystemUser> systemUsers = new SystemUsersGenerator().systemUsersGenerator(permissionTypeRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C:\\Users\\EllepsisRT\\Documents\\IdeaProjects\\DatabaseGenerator\\jsonGeneratedFiles\\SystemUsers.json");
        //mapper.writeValue(file, systemUsers);
        final CollectionType systemUserListType = mapper.getTypeFactory().constructCollectionType(List.class, SystemUser.class);
        List<SystemUser> systemUsers = mapper.readValue(file, systemUserListType);
        systemUserRepository.save(systemUsers);
    }

    private void generateEmployees(int count) throws URISyntaxException, IOException {
        //List<Employee> employees = new EmployeesGenerator().generateEmployees(systemUserRepository, permissionTypeRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C:\\Users\\EllepsisRT\\Documents\\IdeaProjects\\DatabaseGenerator\\jsonGeneratedFiles\\Employees.json");
        //mapper.writeValue(file, employees);
        final CollectionType systemUserListType = mapper.getTypeFactory().constructCollectionType(List.class, Employee.class);
        List<Employee> employees = mapper.readValue(file, systemUserListType);
        employeeRepository.save(employees);
    }
}
