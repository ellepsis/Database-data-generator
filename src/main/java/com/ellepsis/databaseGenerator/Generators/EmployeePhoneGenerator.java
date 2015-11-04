package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.ClientPhone;
import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.EmployeePhone;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 04.11.2015.
 */
public class EmployeePhoneGenerator {
    Random r = new Random();

    public List<EmployeePhone> generate(EmployeeRepository employeeRepository) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        List<EmployeePhone> employeePhones = new ArrayList<>(1000);
        long employeesCount = employeeRepository.count();
        for (long i = 0; i < (employeesCount / 1000) + 1; i++) {
            URI uri = new URI("https://mockaroo.com/150d1730/download?count=1000&key=bfda25a0");
            EmployeePhone[] employeePhonesArray = restTemplate.getForObject(uri, EmployeePhone[].class);
            employeePhones.addAll(Arrays.asList(employeePhonesArray));
        }
        processEmployeePhones(employeePhones, employeesCount);
        listRepair(employeePhones, employeeRepository);
        return employeePhones;
    }

    public void processEmployeePhones(List<EmployeePhone> employeePhones, long employeesCount){
        final String homeDescription = "Home";
        final String mobileDescription = "Mobile";
        final String otherDescription = "Other";
        for (EmployeePhone employeePhone: employeePhones) {
            int num = r.nextInt(10);
            if (num<8) employeePhone.setDescription(mobileDescription);
            else if(num<9) employeePhone.setDescription(otherDescription);
            else employeePhone.setDescription(homeDescription);
        }
    }

    public List<EmployeePhone> listRepair(List<EmployeePhone> employeePhones, EmployeeRepository employeeRepository){
        List<Employee> employees = employeeRepository.findAll();
        for (int i = 0; i < employees.size(); i++){
            employeePhones.get(i).setEmployeeId(employees.get(i));
        }
        for (int i = employees.size(); i < employeePhones.size(); i++){
            employeePhones.get(i).setEmployeeId(employees.get(r.nextInt(employees.size()-1)));
        }
        return employeePhones;
    }
}
