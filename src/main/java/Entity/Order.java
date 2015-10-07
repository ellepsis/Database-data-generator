package Entity;

import java.util.Date;

/**
 * Created by EllepsisRT on 05.10.2015.
 */
public class Order {
    long id;
    long statusOrderId;
    long dispatcherId;
    long driverId;
    Date date;
    Date preorderDate;
    long startPointId;
    long endPointId;
    long carId;
    long clientId;
    long phoneId;
    long cost;
    String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(long statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public long getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(long dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPreorderDate() {
        return preorderDate;
    }

    public void setPreorderDate(Date preorderDate) {
        this.preorderDate = preorderDate;
    }

    public long getStartPointId() {
        return startPointId;
    }

    public void setStartPointId(long startPointId) {
        this.startPointId = startPointId;
    }

    public long getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(long endPointId) {
        this.endPointId = endPointId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
