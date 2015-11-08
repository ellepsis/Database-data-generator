package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.StatusOrder;
import com.sun.xml.internal.ws.api.message.Packet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EllepsisRT on 08.11.2015.
 */
public class StatusOrderGenerator {
    public List<StatusOrder> generate(){
        List<StatusOrder> statusOrders = new ArrayList<>(5);
        StatusOrder statusOrder = new StatusOrder();
        statusOrder.setName("Принят диспетчеком");
        statusOrders.add(statusOrder);
        statusOrder = new StatusOrder();
        statusOrder.setName("Клиент ожидает");
        statusOrders.add(statusOrder);
        statusOrder = new StatusOrder();
        statusOrder.setName("В пути");
        statusOrders.add(statusOrder);
        statusOrder = new StatusOrder();
        statusOrder.setName("Завершен");
        statusOrders.add(statusOrder);
        return statusOrders;
    }
}
