package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by EllepsisRT on 09.10.2015.
 */
@Entity
@Table(name = "Permission_Type")
public class PermissionType extends GenericEntity{
    @Column
    private Long permission;

    @Column
    private String description;
}
