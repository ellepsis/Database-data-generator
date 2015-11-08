package com.ellepsis.databaseGenerator.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.Year;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Car")
public class Car extends GenericEntity{



    @Column(name = "Brand", nullable = false)
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Government_Number", nullable = false)
    private String governmentNumber;

    @Column(name = "VIN")
    private String VIN;

    @Column(name = "Insurance_Number")
    private String insuranceNumber;

    @Column(name = "Release_Year")
    private String releaseYear;

    @JsonIgnore
    @ManyToOne(targetEntity = StatusCar.class)
    @JoinColumn(name = "Status_Car_ID", nullable = false)
    private StatusCar statusCarId;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGovernmentNumber() {
        return governmentNumber;
    }

    public void setGovernmentNumber(String governmentNumber) {
        this.governmentNumber = governmentNumber;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public StatusCar getStatusCarId() {
        return statusCarId;
    }

    public void setStatusCarId(StatusCar statusCarId) {
        this.statusCarId = statusCarId;
    }
}
