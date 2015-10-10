package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class SystemUsersGenerator {
    public List<SystemUser> systemUsersGenerator(EmployeeRepository employeeRepository) throws URISyntaxException {
        List<Employee> employees = employeeRepository.findAll();
        List<SystemUser> systemUsers = new ArrayList<>();
        int usersCount = 0;
        for (int i = 0; i <= employees.size()/1000; i++){
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/16b42010/download?count=1000&key=bfda25a0");
            SystemUser[] systemUsersArray = restTemplate.getForObject(uri, SystemUser[].class);
            for (; usersCount < employees.size(); usersCount++){
                systemUsers.add(systemUsersArray[usersCount%1000]);
            }
        }
        return systemUsers;
    }
}
