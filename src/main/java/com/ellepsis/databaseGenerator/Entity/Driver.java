package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Driver")
public class Driver extends GenericEntity{
    @OneToOne
    @JoinColumn(name = "Employee_Id")
    private Employee employeeId;

    @Column(name = "Driver_License_Number")
    private String driverLicenseNumber;

    @Column(name = "Categories")
    private  String categories;

    @Column(name = "Experience")
    private Date experience;

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

    public Date getExperience() {
        return experience;
    }

    public void setExperience(Date experience) {
        this.experience = experience;
    }
}
