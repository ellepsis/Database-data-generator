package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Driver")
public class Driver extends GenericEntity{

    @Column(name = "Id")
    private Long id;

    @Column(name = "Employee_Id")
    private Long employeeId;

    @Column(name = "Driver_License_Number")
    private String driverLicenseNumber;

    @Column(name = "Categories")
    private  String categories;

    @Column(name = "Experience")
    private Date experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
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
