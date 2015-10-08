package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Dispatcher")
public class Dispatcher extends GenericEntity{

    @Column(name = "Id")
    private Long id;

    @Column(name = "Employee_ID")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
