package com.ellepsis.databaseGenerator.Entity;

import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
public class WorkDate extends GenericEntity{
    private  Long EmployeeId;
    private  Date startDate;
    private  Date endDate;

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
