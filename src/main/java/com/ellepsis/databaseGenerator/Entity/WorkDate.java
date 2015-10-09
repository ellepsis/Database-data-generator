package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Work_Date")
public class WorkDate extends GenericEntity{

    @ManyToOne
    @JoinColumn(name = "Employee_Id")
    private Employee EmployeeId;

    @Column(name = "Start_Date")
    private  Date startDate;

    @Column(name = "End_Date")
    private  Date endDate;

    public Employee getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Employee employeeId) {
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
