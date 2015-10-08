package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Client_Type")
public class ClientType extends GenericEntity{

    @Column(name = "Description")
    private String description;

    @Column(name = "Discount", nullable = false)
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
