package com.ellepsis.databaseGenerator.Entity;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
public class EmployeePhone extends GenericEntity{
    private Long EmployeeId;
    private String phoneNumber;
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
