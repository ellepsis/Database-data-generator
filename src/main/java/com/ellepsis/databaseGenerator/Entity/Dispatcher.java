package com.ellepsis.databaseGenerator.Entity;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
public class Dispatcher extends GenericEntity{
    private Long id;
    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
