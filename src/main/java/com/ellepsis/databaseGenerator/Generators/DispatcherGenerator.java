package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Dispatcher;
import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by EllepsisRT on 04.11.2015.
 */
public class DispatcherGenerator {
    public List<Dispatcher> generate(EmployeeRepository employeeRepository) {
        List<Employee> employeeList = employeeRepository.findAll();
        long count = employeeList.stream().filter(o ->
                o.getPosition().equals(EmployeesGenerator.dispatcherPosition) ||
                        o.getPosition().equals(EmployeesGenerator.administratorPosition) ||
                        o.getPosition().equals(EmployeesGenerator.directorPosition)).count();
        List<Dispatcher> dispatchers = new ArrayList<>(1000);
        for (int i = 0; i < count; i++) {
            dispatchers.add(new Dispatcher());
        }
        listRepair(dispatchers, employeeRepository);
        return dispatchers;
    }

    public List<Dispatcher> listRepair(List<Dispatcher> dispatchers, EmployeeRepository employeeRepository) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> findResult =  employeeList.stream().filter(o ->
                o.getPosition().equals(EmployeesGenerator.dispatcherPosition) ||
                        o.getPosition().equals(EmployeesGenerator.administratorPosition) ||
                        o.getPosition().equals(EmployeesGenerator.directorPosition)).collect(Collectors.toList());
        for (int i = 0; i < dispatchers.size(); i++){
            dispatchers.get(i).setEmployee(employeeList.get(i));
        }
        return dispatchers;
    }
}
