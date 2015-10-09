package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Taxi_Order")
public class TaxiOrder extends GenericEntity{

    @Column(name = "Status_Order_Id")
    private Long statusOrderId;

    @Column(name = "Dispatcher_Id")
    private Long dispatcherId;

    @Column(name = "Driver_Id")
    private Long driverId;

    @Column(name = "Order_Date")
    private Date orderDate;

    @Column(name = "Preorder_Date")
    private Date preorderDate;

    @Column(name = "Start_Point_Id")
    private Long startPointId;

    @Column(name = "End_Point_Id")
    private Long endPointId;

    @Column(name = "Car_Id")
    private Long carId;

    @Column(name = "Client_Id")
    private Long clientId;

    @Column(name = "Phone_Id")
    private Long phoneId;

    @Column(name = "Cost")
    private Long cost;

    @Column(name = "Order_Comment")
    private String orderComment;

    public Long getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(Long statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public Long getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(Long dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPreorderDate() {
        return preorderDate;
    }

    public void setPreorderDate(Date preorderDate) {
        this.preorderDate = preorderDate;
    }

    public Long getStartPointId() {
        return startPointId;
    }

    public void setStartPointId(Long startPointId) {
        this.startPointId = startPointId;
    }

    public Long getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(Long endPointId) {
        this.endPointId = endPointId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }
}
