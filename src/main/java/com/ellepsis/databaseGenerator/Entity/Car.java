package com.ellepsis.databaseGenerator.Entity;

import java.time.Year;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
public class Car extends GenericEntity{
    private String brand;
    private String model;
    private String governmentNumber;
    private String VIN;
    private String vehicleRegistrationCertificate;
    private String insuranceNumber;
    private Year releaseYear;
    private Long statusCarId;

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

    public Long getStatusCarId() {
        return statusCarId;
    }

    public void setStatusCarId(Long statusCarId) {
        this.statusCarId = statusCarId;
    }
}