package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Employee")
public class Employee extends GenericEntity{

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Second_Name")
    private String secondName;

    @Column(name = "Middle_Name")
    private String middleName;

    @Column(name = "Gender")
    private Character gender;

    @Column(name = "Position")
    private String position;

    @Column(name = "Birthday_Date")
    private Date birthdayDate;

    @Column(name = "Passport_Number")
    private String passportNumber;

    @Column(name = "Address_Id")
    private String addressId;

    @Column(name = "Employment_Date")
    private Date employmentDate;

    @Column(name = "Dismissal_Date")
    private Date dismissalDate;

    @OneToOne
    @JoinColumn(name = "User_Id")
    private SystemUser userId;

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
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
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

    public SystemUser getUserId() {
        return userId;
    }

    public void setUserId(SystemUser userId) {
        this.userId = userId;
    }
}
