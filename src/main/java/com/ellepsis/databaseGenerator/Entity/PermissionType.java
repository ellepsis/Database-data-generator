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
    @Column(unique = true)
    private Long permission;

    @Column(unique = true)
    private String description;

    public Long getPermission() {
        return permission;
    }

    public void setPermission(Long permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
