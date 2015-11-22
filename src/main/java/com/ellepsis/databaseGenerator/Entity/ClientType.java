package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Client_Type")
public class ClientType extends GenericEntity{

    @Column(name = "Description")
    private String description;

    @Column(name = "Discount", nullable = false, columnDefinition="Number(19,2)")
    private BigDecimal discount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
