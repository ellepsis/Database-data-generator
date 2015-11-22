package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 22.11.2015.
 */
@Entity
@Table(name = "CAR_OWNER")
public class CarOwner extends GenericEntity {

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "CAR_ID", nullable = false)
    private Car carID;

    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(name = "DRIVER_ID", nullable = false)
    private Driver driverId;

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

    public Car getCarID() {
        return carID;
    }

    public void setCarID(Car carID) {
        this.carID = carID;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }
}
