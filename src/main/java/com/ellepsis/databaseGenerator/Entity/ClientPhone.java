package com.ellepsis.databaseGenerator.Entity;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
public class ClientPhone extends GenericEntity{
    private Long clientId;
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
