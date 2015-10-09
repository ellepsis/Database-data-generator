package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.time.Year;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
@Entity
@Table(name = "Car")
public class Car extends GenericEntity{

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Government_Number")
    private String governmentNumber;

    @Column(name = "VIN")
    private String VIN;

    @Column(name = "VehicleRegCertificate")
    private String vehicleRegistrationCertificate;

    @Column(name = "Insurance_Number")
    private String insuranceNumber;

    @Column(name = "Release_Year")
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "Status_Car_Id")
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

    public String getVehicleRegistrationCertificate() {
        return vehicleRegistrationCertificate;
    }

    public void setVehicleRegistrationCertificate(String vehicleRegistrationCertificate) {
        this.vehicleRegistrationCertificate = vehicleRegistrationCertificate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public StatusCar getStatusCarId() {
        return statusCarId;
    }

    public void setStatusCarId(StatusCar statusCarId) {
        this.statusCarId = statusCarId;
    }
}
