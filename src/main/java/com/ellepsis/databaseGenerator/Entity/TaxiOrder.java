package com.ellepsis.databaseGenerator.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
@Entity
@Table(name = "Taxi_Order")
public class TaxiOrder extends GenericEntity{

    @ManyToOne
    @JoinColumn(name = "Status_Order_Id")
    private StatusOrder statusOrderId;

    @ManyToOne
    @JoinColumn(name = "Dispatcher_Id")
    private Dispatcher dispatcherId;

    @ManyToOne
    @JoinColumn(name = "Driver_Id")
    private Driver driverId;

    @Column(name = "Order_Date")
    private Date orderDate;

    @Column(name = "Preorder_Date")
    private Date preorderDate;

    @Column(name = "Start_Point")
    private String startPointId;

    @Column(name = "End_Point")
    private String endPointId;

    @ManyToOne
    @JoinColumn(name = "Car_Id")
    private Car carId;

    @ManyToOne
    @JoinColumn(name = "Client_Id")
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "Phone_Id")
    private ClientPhone phoneId;

    @Column(name = "Cost")
    private Long cost;

    @Column(name = "Order_Comment")
    private String orderComment;

    public StatusOrder getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(StatusOrder statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public Dispatcher getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(Dispatcher dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
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

    public String getStartPointId() {
        return startPointId;
    }

    public void setStartPointId(String startPointId) {
        this.startPointId = startPointId;
    }

    public String getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(String endPointId) {
        this.endPointId = endPointId;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public ClientPhone getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(ClientPhone phoneId) {
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
