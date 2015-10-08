package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */

@Entity
public class Client extends GenericEntity{

    @Column(name = "First_Name", nullable = false)
    private String firstName;
    @Column(name = "Second_Name", nullable = false)
    private String secondName;
    @Column(name = "Middle_Name")
    private String middleName;
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

    public ClientType getClientTypeId() {
        return clientType;
    }

    public void setClientTypeId(ClientType clientType) {
        this.clientType = clientType;
    }
}
