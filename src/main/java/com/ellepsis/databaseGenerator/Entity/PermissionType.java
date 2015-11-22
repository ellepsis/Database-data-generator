package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;

/**
 * Created by EllepsisRT on 09.10.2015.
 */
@Entity
@Table(name = "Permission_Type")
public class PermissionType{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence_permission_type")
    @SequenceGenerator(name = "id_Sequence_permission_type", sequenceName = "S_PERMISSION_TYPE")
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
