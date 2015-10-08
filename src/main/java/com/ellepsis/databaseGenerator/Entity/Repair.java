package com.ellepsis.databaseGenerator.Entity;

import java.util.Date;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
public class Repair extends GenericEntity{
    private Long carId;
    private Date startDate;
    private Date endDate;
    private Long cost;
    private String place;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
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
