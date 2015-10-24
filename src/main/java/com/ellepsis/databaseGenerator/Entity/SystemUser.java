package com.ellepsis.databaseGenerator.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "System_User")
public class SystemUser{

    @Id
    @Column(name = "Employee_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "User_Name", unique = true)
    private String userName;

    @Column(name = "Password")
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Permissions_Type_Id")
    private PermissionType permissionsTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
