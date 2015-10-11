package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.PermissionType;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import com.ellepsis.databaseGenerator.Repository.CarRepository;
import com.ellepsis.databaseGenerator.Repository.PermissionTypeRepository;
import com.ellepsis.databaseGenerator.Repository.SystemUserRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class EmployeesGenerator {

    Random r = new Random();

    public List<Employee> generateEmployees(SystemUserRepository systemUserRepository,
                                            PermissionTypeRepository permissionTypeRepository,
                                            int count)
            throws URISyntaxException {
        List<Employee> employees = new ArrayList<>();
        List<SystemUser> users = systemUserRepository.findAll();
        List<PermissionType> permissionTypes = permissionTypeRepository.findAll();

        int employeeNumber = 0;
        for (int i = 0; i <= count/1000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/33f32ef0/download?count=1000&key=bfda25a0");
            Employee[] employeesArray = restTemplate.getForObject(uri, Employee[].class);
            int k = 0;
            for (int j = employees.size(); j < count; j++) {
                processEmployee(employeesArray[k], k, users, permissionTypes);
                systemUserRepository.save(employeesArray[k].getUserId());
                employees.add(employeesArray[k++]);
            }
            employeeNumber++;
        }
        return employees;
    }

    private void processEmployee(Employee employee, int employeeNumber, List<SystemUser> users,
                                 List<PermissionType> permissionTypes) {
        String middleName = employee.getMiddleName();
        if (employee.getGender() == 'M') employee.setMiddleName(middleName + "ovich");
        else employee.setMiddleName(middleName + "ovna");
        SystemUser systemUser = users.get(employeeNumber);
        employee.setUserId(users.get(employeeNumber));
        setPositionAndPermission(employee, permissionTypes);
        employee.setPassportNumber(String.format("%10d", r.nextLong() % 9999999999L));
    }

    private void setPositionAndPermission(Employee employee, List<PermissionType> permissionTypes) {
        final String directorPosition = "Директор";
        final String cleanerPosition = "Уборщица";
        final String administratorPosition = "Администратор";
        final String driverPosition = "Водитель";
        final String dispatcherPosition = "Диспетчер";
        final PermissionType directorPermissionType = permissionTypes.stream().
                filter(o -> o.getDescription().contains("Director")).findFirst().get();
        final PermissionType cleanerPermissionType = permissionTypes.stream().
                filter(o -> o.getDescription().contains("Cleaner")).findFirst().get();
        final PermissionType administratorPermissionType = permissionTypes.stream().
                filter(o -> o.getDescription().contains("Manager")).findFirst().get();
        final PermissionType driverPermissionType = permissionTypes.stream().
                filter(o -> o.getDescription().contains("Driver")).findFirst().get();
        final PermissionType dispatcherPermissionType = permissionTypes.stream().
                filter(o -> o.getDescription().contains("Dispatcher")).findFirst().get();
        int rValue = r.nextInt(1000);
        String position = null;
        PermissionType permissionType;
        if (rValue < 3){
            position = directorPosition;
            permissionType = directorPermissionType;
        }
        else if (rValue < 50){
            position = cleanerPosition;
            permissionType = cleanerPermissionType;
        }
        else if (rValue < 100){
            position = administratorPosition;
            permissionType = administratorPermissionType;
        }
        else if (rValue < 600){
            position = driverPosition;
            permissionType = driverPermissionType;
        }
        else{
            position = dispatcherPosition;
            permissionType = dispatcherPermissionType;
        }
        employee.getUserId().setPermissionsTypeId(permissionType);
        employee.setPosition(position);
    }
}
