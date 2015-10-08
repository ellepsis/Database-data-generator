package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Client_Phone")
public class ClientPhone extends GenericEntity{

    @Column(name = "Client_Id")
    private Long clientId;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
