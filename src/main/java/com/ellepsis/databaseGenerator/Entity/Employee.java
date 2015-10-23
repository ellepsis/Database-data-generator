package com.ellepsis.databaseGenerator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Employee")
public class Employee extends GenericEntity{

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Second_Name", nullable = false)
    private String secondName;

    @Column(name = "Middle_Name")
    private String middleName;

    @Column(name = "Gender", nullable = false)
    private Character gender;

    @Column(name = "Position")
    private String position;

    @Column(name = "Birthday_Date", nullable = false)
    private Date birthdayDate;

    @Column(name = "Passport_Number")
    private String passportNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "Employment_Date", nullable = false)
    private Date employmentDate;

    @Column(name = "Dismissal_Date")
    private Date dismissalDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAddressId() {
        return address;
    }

    public void setAddressId(String addressId) {
        this.address = addressId;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }
}
