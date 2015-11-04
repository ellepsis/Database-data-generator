package com.ellepsis.databaseGenerator.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Driver")
public class Driver extends GenericEntity{

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "Employee_Id")
    private Employee employeeId;

    @Column(name = "Driver_License_Number")
    private String driverLicenseNumber;

    @Column(name = "Categories")
    private  String categories;

    @Column(name = "Experience")
    private String experience;

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
