package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Dispatcher;
import com.ellepsis.databaseGenerator.Entity.Driver;
import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.EmployeePhone;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by EllepsisRT on 04.11.2015.
 */
public class DriverGenerator {
    Random r = new Random();
    public List<Driver> generate(EmployeeRepository employeeRepository) {
        List<Employee> employeeList = employeeRepository.findAll();
        long count = employeeList.stream().filter(o ->
                o.getPosition().equals(EmployeesGenerator.driverPosition) ||
                        o.getPosition().equals(EmployeesGenerator.directorPosition)).count();
        List<Driver> drivers = new ArrayList<>(1000);
        for (int i = 0; i < count; i++) {
            drivers.add(new Driver());
        }
        processDrivers(drivers);
        listRepair(drivers, employeeRepository);
        return drivers;
    }

    private void processDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
            driver.setDriverLicenseNumber(Long.toString(((long)(r.nextDouble()*(10e10)))));
            driver.setCategories("B");
            if (r.nextInt(100)<30) driver.setCategories(driver.getCategories()+"C");
            if (r.nextInt(100)<20) driver.setCategories(driver.getCategories()+"D");
            driver.setExperience(Integer.toString(1985+r.nextInt(30)));
        }
    }

    public List<Driver> listRepair(List<Driver> drivers, EmployeeRepository employeeRepository) {
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> findResult = employees.stream().filter(o ->
                o.getPosition().equals(EmployeesGenerator.driverPosition) ||
                        o.getPosition().equals(EmployeesGenerator.directorPosition)).collect(Collectors.toList());
        for (int i = 0; i < drivers.size(); i++) {
            drivers.get(i).setEmployeeId(employees.get(i));
            drivers.get(i).setId(employees.get(i).getId());
        }
        return drivers;
    }
}
