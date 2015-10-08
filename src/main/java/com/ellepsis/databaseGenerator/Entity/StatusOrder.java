package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Status_Order")
public class StatusOrder extends GenericEntity{

    @Column(name = "Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
