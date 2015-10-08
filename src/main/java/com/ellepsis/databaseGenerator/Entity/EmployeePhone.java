package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Employee_Phone")
public class EmployeePhone extends GenericEntity{

    @Column(name = "EmployeeId")
    private Long EmployeeId;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Description")
    private String description;

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
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
