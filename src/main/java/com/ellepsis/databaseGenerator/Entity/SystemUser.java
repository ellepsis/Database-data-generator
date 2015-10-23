package com.ellepsis.databaseGenerator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "System_User")
public class SystemUser {

    @OneToOne(targetEntity = Employee.class)
    @JoinColumn(name = "Employee_ID", unique = true)
    private Employee EmployeeID;

    @Column(name = "User_Name", unique = true)
    private String userName;

    @Column(name = "Password")
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Permissions_Type_Id")
    private PermissionType permissionsTypeId;

    public Employee getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        EmployeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PermissionType getPermissionsTypeId() {
        return permissionsTypeId;
    }

    public void setPermissionsTypeId(PermissionType permissionsTypeId) {
        this.permissionsTypeId = permissionsTypeId;
    }

}
