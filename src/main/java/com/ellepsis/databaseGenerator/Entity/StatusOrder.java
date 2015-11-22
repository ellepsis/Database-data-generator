package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Status_Order")
public class StatusOrder{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence_status_order")
    @SequenceGenerator(name = "id_Sequence_status_order", sequenceName = "S_STATUS_ORDER")
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
