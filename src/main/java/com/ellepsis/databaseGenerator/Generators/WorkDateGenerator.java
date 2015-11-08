package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.WorkDate;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;

import java.util.*;

/**
 * Created by EllepsisRT on 08.11.2015.
 */
public class WorkDateGenerator {

    public List<WorkDate> generate(int count, EmployeeRepository employeeRepository) {
        List<Employee> employees = employeeRepository.findAll();
        List<WorkDate> allWorkDates = new LinkedList();
        for(Employee employee: employees) {
            allWorkDates.addAll(generateWorkDates(count, employee));
        }
        return allWorkDates;
    }

    private List<WorkDate> generateWorkDates(int count, Employee employeeId) {
        List<WorkDate> workDates = new ArrayList();
        for(int i = 0; i < count; i++) {
            workDates.add(generateWorkDate(employeeId));
        }
        return workDates;
    }

    private WorkDate generateWorkDate(Employee employeeId) {
        Random random = new Random();

        int start_year = 1990 + random.nextInt(15);
        int start_mouth = random.nextInt(12) + 1;
        int start_day = random.nextInt(29)+1;
        int start_hour = random.nextInt(24);
        int start_minutes = random.nextInt(60);

        Calendar calendar = new GregorianCalendar(start_year, start_mouth, start_day, start_hour, start_minutes);
        Date start_date = calendar.getTime();
        calendar.add(Calendar.HOUR, random.nextInt(8));
        Date end_data = calendar.getTime();

        WorkDate workDate = new WorkDate();
        workDate.setEmployeeId(employeeId);
        workDate.setStartDate(start_date);
        workDate.setEndDate(end_data);
        return  workDate;
    }

    public List<WorkDate> listRepair(List<WorkDate> workDates, EmployeeRepository employeeRepository){
        List<WorkDate> newWorkDates;
        long employeeCount = employeeRepository.count();
        newWorkDates = generate((int) (workDates.size()/employeeCount), employeeRepository);
        workDates = newWorkDates;
        return newWorkDates;
    }
}
