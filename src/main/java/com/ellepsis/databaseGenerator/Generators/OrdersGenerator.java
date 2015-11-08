package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.*;
import com.ellepsis.databaseGenerator.Repository.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class OrdersGenerator {
    Random r = new Random();

    public List<TaxiOrder> generate(int count, CarRepository carRepository, ClientRepository clientRepository,
                                    DispatcherRepository dispatcherRepository, DriverRepository driverRepository,
                                    ClientPhoneRepository clientPhoneRepository,
                                    StatusOrderRepository statusOrderRepository) throws URISyntaxException {
        List<TaxiOrder> taxiOrders = new ArrayList<>();
        for (int i = 0; i <= count / 1000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/7837bcf0/download?count=1000&key=04eaa770");
            TaxiOrder[] taxiOrdersArray = restTemplate.getForObject(uri, TaxiOrder[].class);
            int k = 0;
            for (int j = 0; j < 1000 && taxiOrders.size()<count; j++) {
                processTaxiOrder(taxiOrdersArray[k]);
                taxiOrders.add(taxiOrdersArray[k++]);
            }
        }
        listRepair(taxiOrders, carRepository, clientRepository, dispatcherRepository, driverRepository,
                clientPhoneRepository, statusOrderRepository);
        return taxiOrders;
    }

    private void processTaxiOrder(TaxiOrder taxiOrder) {
        if (taxiOrder.getPreorderDate() != null) {
            if (taxiOrder.getPreorderDate().compareTo(taxiOrder.getOrderDate()) < 0) {
                taxiOrder.setPreorderDate(new Date(taxiOrder.getOrderDate().getTime() + 1000 * (r.nextInt(60 * 60 * 24 * 2) + 60 * 60)));
            }
        }
        if (taxiOrder.getOrderComment() != null && taxiOrder.getOrderComment().length() > 254)
            taxiOrder.setOrderComment(taxiOrder.getOrderComment().substring(0, 254));
        if (taxiOrder.getStartPoint().length() > 254)
            taxiOrder.setStartPointId(taxiOrder.getStartPoint().substring(0, 254));
    }

    public List<TaxiOrder> listRepair(List<TaxiOrder> taxiOrders, CarRepository carRepository,
                                      ClientRepository clientRepository, DispatcherRepository dispatcherRepository,
                                      DriverRepository driverRepository, ClientPhoneRepository clientPhoneRepository,
                                      StatusOrderRepository statusOrderRepository){
        List<Car> cars = carRepository.findAll();
        List<Client> clients = clientRepository.findAll();
        List<Dispatcher> dispatchers = dispatcherRepository.findAll();
        List<Driver> drivers = driverRepository.findAll();
        List<ClientPhone> clientPhones = clientPhoneRepository.findAll();
        List<StatusOrder> statusOrders = statusOrderRepository.findAll();

        for (TaxiOrder taxiOrder : taxiOrders){
            taxiOrder.setCarId(cars.get(r.nextInt(cars.size())));
            taxiOrder.setClientId(clients.get(r.nextInt(clients.size())));
            taxiOrder.setDispatcherId(dispatchers.get(r.nextInt(dispatchers.size())));
            taxiOrder.setDriverId(drivers.get(r.nextInt(drivers.size())));
            taxiOrder.setPhoneId(clientPhones.get(r.nextInt(clientPhones.size())));
            taxiOrder.setStatusOrderId(statusOrders.get(r.nextInt(statusOrders.size())));
        }
        return taxiOrders;
    }
}
