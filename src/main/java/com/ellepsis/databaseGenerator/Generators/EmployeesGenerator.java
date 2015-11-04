package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
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
public class EmployeesGenerator {

    public final static String directorPosition = "Директор";
    public final static String cleanerPosition = "Уборщица";
    public final static String administratorPosition = "Администратор";
    public final static String driverPosition = "Водитель";
    public final static String dispatcherPosition = "Диспетчер";

    Random r = new Random();

    public List<Employee> generateEmployees(int count) throws URISyntaxException {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i <= count/1000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/33f32ef0/download?count=1000&key=bfda25a0");
            Employee[] employeesArray = restTemplate.getForObject(uri, Employee[].class);
            int k = 0;
            for (int j = employees.size(); j < count; j++) {
                processEmployee(employeesArray[k]);
                employees.add(employeesArray[k++]);
            }
        }
        return employees;
    }

    private void processEmployee(Employee employee) {
        String middleName = employee.getMiddleName();
        if (employee.getGender() == 'M') employee.setMiddleName(middleName + "ovich");
        else employee.setMiddleName(middleName + "ovna");
        employee.setPassportNumber(String.format("%10d", r.nextLong() % 9999999999L));
        setPosition(employee);
    }

    private void setPosition(Employee employee) {
        int rValue = r.nextInt(1000);
        String position;
        if (rValue < 3){
            position = directorPosition;
        }
        else if (rValue < 50){
            position = cleanerPosition;
        }
        else if (rValue < 100){
            position = administratorPosition;
        }
        else if (rValue < 600){
            position = driverPosition;
        }
        else{
            position = dispatcherPosition;
        }
        employee.setPosition(position);
    }
}
