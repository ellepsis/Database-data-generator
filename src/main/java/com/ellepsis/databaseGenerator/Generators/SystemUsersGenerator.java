package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.PermissionType;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;
import com.ellepsis.databaseGenerator.Repository.PermissionTypeRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class SystemUsersGenerator {

    Random r = new Random();

    public List<SystemUser> systemUsersGenerator(PermissionTypeRepository permissionTypeRepository,
                                                 EmployeeRepository employeeRepository, int count) throws URISyntaxException {
        List<SystemUser> systemUsers = new ArrayList<>();
        int usersCount = 0;
        for (int i = 0; i <= count / 1000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/16b42010/download?count=1000&key=bfda25a0");
            SystemUser[] systemUsersArray = restTemplate.getForObject(uri, SystemUser[].class);
            int k = 0;
            for (int j = systemUsers.size(); j < count; j++) {
                systemUsers.add(systemUsersArray[k++]);
            }
        }
        listRepair(systemUsers, permissionTypeRepository, employeeRepository);
        return systemUsers;
    }

    private void setPermission(Employee employee, SystemUser systemUser, List<PermissionType> permissionTypes) {
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
        PermissionType permissionType;

        switch (employee.getPosition()) {
            case directorPosition:
                permissionType = directorPermissionType;
                break;
            case cleanerPosition:
                permissionType = cleanerPermissionType;
                break;
            case administratorPosition:
                permissionType = administratorPermissionType;
                break;
            case driverPosition:
                permissionType = driverPermissionType;
                break;
            default:
                permissionType = dispatcherPermissionType;
                break;
        }

        systemUser.setPermissionsTypeId(permissionType);
    }

    public void listRepair(List<SystemUser> systemUsers, PermissionTypeRepository permissionTypeRepository,
                           EmployeeRepository employeeRepository) {
        List<PermissionType> permissionTypes = permissionTypeRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        for (int i = 0; i < employees.size(); i++) {
            systemUsers.get(i).setId(employees.get(i).getId());
            systemUsers.get(i).setEmployee(employees.get(i));
            setPermission(employees.get(i), systemUsers.get(i), permissionTypes);
        }
    }
}
