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
import java.security.Permission;
import java.util.ArrayList;
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
    @Autowired private StatusCarRepository statusCarRepository;
    @Autowired private CarRepository carRepository;

    /* !!!---> change for you <---!!! */
    //private String basePath = "D:\\DatabaseGenerator";
    private String basePath = "C:\\Users\\EllepsisRT\\Documents\\IdeaProjects\\DatabaseGenerator";

    public void generate() throws IOException, URISyntaxException {
        //addClients();
        //generateClientPhones();
        //generateEmployeesAndAllWithIt(500);

        //generateStatesCar();
        //loadStatusCar();

        //generateCars(100);
        //loadCar();


        //generatePermissions();
        loadPermissions();

        generateSystemUsers(500);
        loadSystemUsers();

        generateEmployees(500);
        loadEmployees();
    }

    /*=============== Car ===============*/

    private void loadCar() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType carsListType = mapper.getTypeFactory().constructCollectionType(List.class, Car.class);
        File file = new File(basePath+"\\jsonGeneratedFiles\\Cars.json");
        List<Car> cars = mapper.readValue(file, carsListType);
        carRepository.save(cars);
    }

    private void generateCars( int count ) throws IOException {
        CarGenerator carGenerator = new CarGenerator(basePath+"\\auxiliaryFiles\\tmp_cars.txt");
        List<Car> cars = carGenerator.generateCars(statusCarRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath+"\\jsonGeneratedFiles\\Cars.json");
        mapper.writeValue(file, cars);
        //carRepository.save( cars );
    }

    /*=============== Status Car ===============*/

    private void loadStatusCar() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType statusCarListType = mapper.getTypeFactory().constructCollectionType(List.class, StatusCar.class);
        File file = new File(basePath+"\\jsonGeneratedFiles\\StatesCar.json");
        List<StatusCar> statesCar = mapper.readValue(file, statusCarListType);
        statusCarRepository.save(statesCar);
    }

    private void generateStatesCar() throws IOException {
        StatusCarGenerator statusCarGenerator = new StatusCarGenerator();
        List<StatusCar> statesCar = statusCarGenerator.generateStatesCar();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath+"\\jsonGeneratedFiles\\StatesCar.json");
        mapper.writeValue(file, statesCar);
        //statusCarRepository.save(statusCarGenerator.generateStatesCar());
    }

    /*=============== Employees ===============*/

    private void loadEmployees() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType employeesListType = mapper.getTypeFactory().constructCollectionType(List.class, Employee.class);
        File file = new File(basePath+"\\jsonGeneratedFiles\\Employees.json");
        List<Employee> employees = mapper.readValue(file, employeesListType);
        employeeRepository.save(employees);
    }

    private void generateEmployees(int count) throws URISyntaxException, IOException {
        List<Employee> employees = new EmployeesGenerator().generateEmployees(systemUserRepository, permissionTypeRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(basePath + "\\jsonGeneratedFiles\\Employees.json"), employees);
        //employeeRepository.save(employees);
    }

    private void generateEmployeesAndAllWithIt(int count) throws URISyntaxException, IOException {
        generatePermissions();
        generateSystemUsers(count);
        generateEmployees(count);
    }

    /*=============== Client ===============*/

    private void addClients() throws IOException {
        ClientTypesGenerator clientTypesGenerator = new ClientTypesGenerator();
        clientTypeRepository.save(clientTypesGenerator.generateClientType());
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType clientListType = mapper.getTypeFactory().constructCollectionType(List.class, Client.class);
        File file = new File(basePath+"\\jsonGeneratedFiles\\Clients.json");
        List<Client> users = mapper.readValue(file, clientListType);
        clientRepository.save(users);
    }

    /*=============== Client Phone ===============*/

    private void generateClientPhones() throws URISyntaxException, IOException {
        //ClientPhonesGenerator clientPhonesGenerator = new ClientPhonesGenerator();
        //List<ClientPhone> result = clientPhonesGenerator.generateClientPhones(clientRepository);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath+"\\jsonGeneratedFiles\\ClientPhones.json");
        //mapper.writeValue(file, result);
        final CollectionType clientListType = mapper.getTypeFactory().constructCollectionType(List.class, ClientPhone.class);
        List<ClientPhone> clientPhones = mapper.readValue(file, clientListType);
        clientPhoneRepository.save(clientPhones);
    }

    /*=============== Permission ===============*/

    private void loadPermissions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType permissionListType = mapper.getTypeFactory().constructCollectionType(List.class, PermissionType.class);
        File file = new File(basePath+"\\jsonGeneratedFiles\\Permissions.json");
        List<PermissionType> permissions = mapper.readValue(file, permissionListType);
        permissionTypeRepository.save(permissions);
    }

    private void generatePermissions() throws IOException {
        PermissionTypeGenerator permissionTypeGenerator = new PermissionTypeGenerator();
        List<PermissionType> permissionTypes = permissionTypeGenerator.generatePermissionTypes();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath+"\\jsonGeneratedFiles\\Permissions.json");
        mapper.writeValue(file, permissionTypes);
        //permissionTypeRepository.save(permissionTypes);
    }

    /*=============== System User ===============*/

    private void loadSystemUsers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath+"\\jsonGeneratedFiles\\SystemUsers.json");
        final CollectionType systemUserListType = mapper.getTypeFactory().constructCollectionType(List.class, SystemUser.class);
        List<SystemUser> systemUsers = mapper.readValue(file, systemUserListType);
        systemUserRepository.save(systemUsers);
    }

    private void generateSystemUsers(int count) throws URISyntaxException, IOException {
        List<SystemUser> systemUsers = new SystemUsersGenerator().systemUsersGenerator(permissionTypeRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath+"\\jsonGeneratedFiles\\SystemUsers.json");
        mapper.writeValue(file, systemUsers);
        //systemUserRepository.save(systemUsers);
    }
}
