package com.ellepsis.databaseGenerator.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */

@Entity
@Table(name = "Client")
public class Client extends GenericEntity{

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Second_Name")
    private String secondName;

    @Column(name = "Middle_Name")
    private String middleName;

    @Column(name = "Gender")
    private Character gender;

    @JsonIgnore
    @ManyToOne(targetEntity = ClientType.class)
    @JoinColumn(name = "Client_Type_ID", nullable = false)
    private ClientType clientType;

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

    public ClientType getClientType() {
        return clientType;
    }
    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
}
