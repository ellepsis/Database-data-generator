package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;

import java.util.List;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class SystemUsersGenerator {
    public List<SystemUser> systemUsersGenerator(EmployeeRepository employeeRepository){
        List<Employee> employees = employeeRepository.findAll();
        for (int i = 0; )
    }
}
