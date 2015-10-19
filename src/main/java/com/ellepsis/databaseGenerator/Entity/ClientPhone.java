package com.ellepsis.databaseGenerator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Client_Phone")
public class ClientPhone extends GenericEntity{

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Client_Id")
    private Client client;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    public Client getClientId() {
        return client;
    }

    public void setClientId(Client clientId) {
        this.client = clientId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
