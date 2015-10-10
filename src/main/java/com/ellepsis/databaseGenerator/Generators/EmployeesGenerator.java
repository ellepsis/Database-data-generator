package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
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

    public List<Employee> generateEmployees(int count) throws URISyntaxException {
        List<Employee> employees = new ArrayList<>();
        for (int i =0; i < count/1000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/33f32ef0/download?count=1000&key=bfda25a0");
            Employee[] employeesArray = restTemplate.getForObject(uri, Employee[].class);
            for (Employee employee : employeesArray){
                processEmployee(employee);
            }
            int k = 0;
            for (int j = employees.size(); j < count; j++){
                employees.add(employeesArray[k++]);
            }
        }
        return employees;
    }

    private void processEmployee(Employee employee) {
        String middleName = employee.getMiddleName();
        if (employee.getGender() == 'M') employee.setMiddleName(middleName + "ovich");
        else employee.setMiddleName(middleName + "ovna");

    }

    private String getPosition(Employee employee){
        final String directorPosition = "Директор";
        final String cleanerPosition = "Уборщица";
        final String administratorPosition = "Администратор";
        final String driverPosition = "Водитель";
        final String dispatcherPosition = "Диспетчер";

    }
}
