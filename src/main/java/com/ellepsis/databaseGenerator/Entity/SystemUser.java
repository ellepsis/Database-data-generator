package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "System_User")
public class SystemUser extends GenericEntity{

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "Password")
    private String Password;

    @ManyToOne
    @JoinColumn(name = "Permissions_Type_Id")
    private PermissionType permissionsTypeId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public PermissionType getPermissionsTypeId() {
        return permissionsTypeId;
    }

    public void setPermissionsTypeId(PermissionType permissionsTypeId) {
        this.permissionsTypeId = permissionsTypeId;
    }

}
