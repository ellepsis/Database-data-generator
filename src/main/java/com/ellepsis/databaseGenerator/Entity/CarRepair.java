package com.ellepsis.databaseGenerator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Car_Repair")
public class CarRepair extends GenericEntity{

    @JsonIgnore
    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "Car_Id")
    private Car carId;

    @Column(name = "Start_Date")
    private Date startDate;

    @Column(name = "End_Date")
    private Date endDate;

    @Column(name = "Cost")
    private Long cost;

    @Column(name = "Place")
    private String place;

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
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

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
