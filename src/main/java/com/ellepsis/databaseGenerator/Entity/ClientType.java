package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Client_Type")
public class ClientType extends GenericEntity{
    private String description;
    @Column(nullable = false)
    private float discount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
