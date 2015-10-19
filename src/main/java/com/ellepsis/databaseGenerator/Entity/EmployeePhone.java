package com.ellepsis.databaseGenerator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Employee_Phone")
public class EmployeePhone extends GenericEntity{

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee EmployeeId;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Description")
    private String description;

    public Employee getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        EmployeeId = employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
