package com.ellepsis.databaseGenerator.Entity;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
public class User extends GenericEntity{
    private String userName;
    private String Password;
    private  Long permissionsTypeId;

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

    public Long getPermissionsTypeId() {
        return permissionsTypeId;
    }

    public void setPermissionsTypeId(Long permissionsTypeId) {
        this.permissionsTypeId = permissionsTypeId;
    }

}
