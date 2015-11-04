package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.*;
import com.ellepsis.databaseGenerator.Repository.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
@Component
@ComponentScan("com.ellepsis.databaseGenerator")
public class EveryThingGenerator {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientTypeRepository clientTypeRepository;
    @Autowired
    private ClientPhoneRepository clientPhoneRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private PermissionTypeRepository permissionTypeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeePhoneRepository employeePhoneRepository;
    @Autowired
    private StatusCarRepository statusCarRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DispatcherRepository dispatcherRepository;

    /* !!!---> change for you <---!!! */
    //private String basePath = "D:\\DatabaseGenerator";
    private String basePath = "C:\\Users\\EllepsisRT\\Documents\\IdeaProjects\\DatabaseGenerator";

    public void generate() throws Exception {
        //generateClientTypes();
        //loadClientTypes();
        //generateClients();
        //loadClients();
        //generateClientPhones();
        //loadClientsPhones();

        //generateStatesCar();
        //loadStatusCar();
        //generateCars(100);
        //loadCar();

        //generatePermissions();
        //loadPermissions();
        //generateEmployees(500);
        //loadEmployees();
        //generateSystemUsers(500);
        //loadSystemUsers();
        //generateEmployeePhones();
        //loadEmployeePhones();

        //generateDispatchers();
        //loadDispatchers();

    }

    public void dbRepair() throws Exception{
        loadClientTypes();
        loadClients();
        loadClientsPhones();

        loadStatusCar();
        loadCar();

        loadPermissions();
        loadEmployees();
        loadSystemUsers();
        loadEmployeePhones();

        loadDispatchers();
    }

    /*=============== Car ===============*/

    private void loadCar() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType carsListType = mapper.getTypeFactory().constructCollectionType(List.class, Car.class);
        File file = new File(basePath + "\\jsonGeneratedFiles\\Cars.json");
        List<Car> cars = mapper.readValue(file, carsListType);
        new CarGenerator().listRepair(cars, statusCarRepository);
        carRepository.save(cars);
    }

    private void generateCars(int count) throws IOException {
        CarGenerator carGenerator = new CarGenerator();
        carGenerator.readValues(basePath + "\\auxiliaryFiles\\tmp_cars.txt");
        List<Car> cars = carGenerator.generateCars(statusCarRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\Cars.json");
        mapper.writeValue(file, cars);
        //carRepository.save( cars );
    }

    /*=============== Status Car ===============*/

    private void loadStatusCar() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType statusCarListType = mapper.getTypeFactory().constructCollectionType(List.class, StatusCar.class);
        File file = new File(basePath + "\\jsonGeneratedFiles\\StatesCar.json");
        List<StatusCar> statesCar = mapper.readValue(file, statusCarListType);
        statusCarRepository.save(statesCar);
    }

    private void generateStatesCar() throws IOException {
        StatusCarGenerator statusCarGenerator = new StatusCarGenerator();
        List<StatusCar> statesCar = statusCarGenerator.generateStatesCar();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\StatesCar.json");
        mapper.writeValue(file, statesCar);
        //statusCarRepository.save(statusCarGenerator.generateStatesCar());
    }

    /*=============== Client ===============*/

    private void loadClientTypes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType clientTypeListType = mapper.getTypeFactory().constructCollectionType(List.class, ClientType.class);
        File file = new File(basePath + "\\jsonGeneratedFiles\\ClientTypes.json");
        List<ClientType> clientTypes = mapper.readValue(file, clientTypeListType);
        clientTypeRepository.save(clientTypes);
    }

    private void generateClientTypes() throws IOException {
        ClientTypesGenerator clientTypesGenerator = new ClientTypesGenerator();
        List<ClientType> clientTypes = clientTypesGenerator.generateClientType();
        clientTypeRepository.save(clientTypes);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\ClientTypes.json");
        mapper.writeValue(file, clientTypes);
    }

    private void loadClients() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType clientListType = mapper.getTypeFactory().constructCollectionType(List.class, Client.class);
        File file = new File(basePath + "\\jsonGeneratedFiles\\Clients.json");
        List<Client> clients = mapper.readValue(file, clientListType);
        new ClientsGenerator().listRepair(clients, clientTypeRepository);
        clientRepository.save(clients);
    }

    private void generateClients() throws Exception {
        ClientsGenerator clientsGenerator = new ClientsGenerator();
        List<Client> clients = clientsGenerator.generateClients(clientTypeRepository, 40);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\Clients.json");
        mapper.writeValue(file, clients);
    }

    /*=============== Client Phone ===============*/

    private void loadClientsPhones() throws URISyntaxException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\ClientPhones.json");
        final CollectionType clientPhonesType = mapper.getTypeFactory().constructCollectionType(List.class, ClientPhone.class);
        List<ClientPhone> clientPhones = mapper.readValue(file, clientPhonesType);
        new ClientPhonesGenerator().listRepair(clientPhones, clientRepository);
        clientPhoneRepository.save(clientPhones);
    }

    private void generateClientPhones() throws URISyntaxException, IOException {
        List<ClientPhone> clientPhones = new ClientPhonesGenerator().generateClientPhones(clientRepository);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\ClientPhones.json");
        mapper.writeValue(file, clientPhones);
    }

    private void generateEmployeesAndAllWithIt(int count) throws URISyntaxException, IOException {
        generatePermissions();
        generateEmployees(count);
        generateSystemUsers(count);
    }

    /*=============== Employees ===============*/

    private void loadEmployees() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType employeesListType = mapper.getTypeFactory().constructCollectionType(List.class, Employee.class);
        File file = new File(basePath + "\\jsonGeneratedFiles\\Employees.json");
        List<Employee> employees = mapper.readValue(file, employeesListType);
        employeeRepository.save(employees);
    }

    private void generateEmployees(int count) throws URISyntaxException, IOException {
        List<Employee> employees = new EmployeesGenerator().generateEmployees(count);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(basePath + "\\jsonGeneratedFiles\\Employees.json"), employees);
        //employeeRepository.save(employees);
    }

    /*=============== Permission ===============*/

    private void loadPermissions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final CollectionType permissionListType = mapper.getTypeFactory().constructCollectionType(List.class, PermissionType.class);
        File file = new File(basePath + "\\jsonGeneratedFiles\\Permissions.json");
        List<PermissionType> permissions = mapper.readValue(file, permissionListType);
        permissionTypeRepository.save(permissions);
    }

    private void generatePermissions() throws IOException {
        List<PermissionType> permissionTypes = new PermissionTypeGenerator().generatePermissionTypes();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\Permissions.json");
        mapper.writeValue(file, permissionTypes);
        //permissionTypeRepository.save(permissionTypes);
    }

    /*=============== System User ===============*/

    private void loadSystemUsers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\SystemUsers.json");
        final CollectionType systemUserListType = mapper.getTypeFactory().constructCollectionType(List.class, SystemUser.class);
        List<SystemUser> systemUsers = mapper.readValue(file, systemUserListType);
        new SystemUsersGenerator().listRepair(systemUsers, permissionTypeRepository, employeeRepository);
        for (SystemUser systemUser : systemUsers){
            systemUserRepository.save(systemUser);
        }
        systemUserRepository.save(systemUsers);
    }

    private void generateSystemUsers(int count) throws URISyntaxException, IOException {
        List<SystemUser> systemUsers = new SystemUsersGenerator().systemUsersGenerator(permissionTypeRepository, employeeRepository, count);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\SystemUsers.json");
        mapper.writeValue(file, systemUsers);
        //systemUserRepository.save(systemUsers);
    }

    /*=============== Employee Phones ================*/

    private void loadEmployeePhones() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\EmployeePhones.json");
        final CollectionType EmployeePhoneListType = mapper.getTypeFactory().constructCollectionType(List.class, EmployeePhone.class);
        List<EmployeePhone> employeePhones = mapper.readValue(file, EmployeePhoneListType);
        new EmployeePhoneGenerator().listRepair(employeePhones, employeeRepository);
        employeePhoneRepository.save(employeePhones);
    }

    private void generateEmployeePhones() throws Exception {
        List<EmployeePhone> employeePhones = new EmployeePhoneGenerator().generate(employeeRepository);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\EmployeePhones.json");
        mapper.writeValue(file, employeePhones);
    }

    /*=============== Dispatchers ====================*/

    private void loadDispatchers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\Dispatchers.json");
        final CollectionType DispatcherListType = mapper.getTypeFactory().constructCollectionType(List.class, Dispatcher.class);
        List<Dispatcher> dispatchers = mapper.readValue(file, DispatcherListType);
        new DispatcherGenerator().listRepair(dispatchers, employeeRepository);
        dispatcherRepository.save(dispatchers);
    }

    private void generateDispatchers() throws IOException {
        List<Dispatcher> dispatchers = new DispatcherGenerator().generate(employeeRepository);
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(basePath + "\\jsonGeneratedFiles\\Dispatchers.json");
        mapper.writeValue(file, dispatchers);
    }
}
