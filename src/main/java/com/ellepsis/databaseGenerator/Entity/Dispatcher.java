package com.ellepsis.databaseGenerator.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Dispatcher")
public class Dispatcher extends GenericEntity{

    @JsonIgnore
    @OneToOne(targetEntity = Employee.class)
    @JoinColumn(name = "Employee_ID")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
