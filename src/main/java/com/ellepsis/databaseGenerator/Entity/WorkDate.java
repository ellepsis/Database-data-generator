package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Work_Date")
public class WorkDate extends GenericEntity{

    @Column(name = "Employee_Id")
    private  Long EmployeeId;

    @Column(name = "Start_Date")
    private  Date startDate;

    @Column(name = "End_Date")
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
