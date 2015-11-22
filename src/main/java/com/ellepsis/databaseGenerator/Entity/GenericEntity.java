package com.ellepsis.databaseGenerator.Entity;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
@MappedSuperclass
public class GenericEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ_INSERT")
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
