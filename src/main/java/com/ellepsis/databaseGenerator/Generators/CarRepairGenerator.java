package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Car;
import com.ellepsis.databaseGenerator.Entity.CarRepair;
import com.ellepsis.databaseGenerator.Entity.ClientPhone;
import com.ellepsis.databaseGenerator.Repository.CarRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by EllepsisRT on 08.11.2015.
 */
public class CarRepairGenerator {

    Random r = new Random();

    public List<CarRepair> generate(CarRepository carRepository, int count) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        List<CarRepair> carRepairs = new ArrayList<>(50);
        for (int i = 0; i < count / 1000 + 1; i++) {
            URI uri = new URI("https://mockaroo.com/d4c1a2e0/download?count=1000&key=bfda25a0");
            CarRepair[] carRepairsArray = restTemplate.getForObject(uri, CarRepair[].class);
            for (int j = carRepairs.size(); j < count; j++) {
                processCarRepairs(carRepairsArray[j]);
                carRepairs.add(carRepairsArray[j]);
            }
        }
        listRepair(carRepairs, carRepository);
        return carRepairs;
    }

    private void processCarRepairs(CarRepair carRepair){
        if (carRepair.getEndDate().compareTo(carRepair.getStartDate())<0){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(carRepair.getStartDate().getTime());
            calendar.add(Calendar.MONTH, 1);
            carRepair.setEndDate(calendar.getTime());
        }
    }

    public List<CarRepair> listRepair(List<CarRepair> carRepairs, CarRepository carRepository) {
        List<Car> cars = carRepository.findAll();
        for (CarRepair carRepair: carRepairs) {
            carRepair.setCarId(cars.get(r.nextInt(cars.size())));
        }
        return carRepairs;
    }
}
