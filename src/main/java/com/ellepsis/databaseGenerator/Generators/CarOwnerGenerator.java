package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Car;
import com.ellepsis.databaseGenerator.Entity.CarOwner;
import com.ellepsis.databaseGenerator.Entity.Driver;
import com.ellepsis.databaseGenerator.Repository.CarRepository;
import com.ellepsis.databaseGenerator.Repository.DriverRepository;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by EllepsisRT on 22.11.2015.
 */
public class CarOwnerGenerator {
    Random r = new Random();
    
    public List<CarOwner> generate(int countForCar, CarRepository carRepository, DriverRepository driverRepository){
        List<CarOwner> carOwners = new ArrayList<>(1000);
        List<Car> cars = carRepository.findAll();
        List<Driver> drivers = driverRepository.findAll();
        int driversCount = drivers.size();
        for (Car car : cars){
            for (int j = 0; j < countForCar; j++){
                CarOwner carOwner = new CarOwner();
                Pair<Date, Date> dates = generateDate();
                carOwner.setStartDate(dates.getKey());
                carOwner.setEndDate(dates.getValue());
                carOwner.setCarID(car);
                carOwner.setDriverId(drivers.get(r.nextInt(driversCount)));
                carOwners.add(carOwner);
            }
        }
        return carOwners;
    }
    
    private Pair<Date, Date> generateDate(){
        int start_year = 2014 + r.nextInt(1);
        int start_mouth = r.nextInt(12) + 1;
        int start_day = r.nextInt(29)+1;
        int start_hour = r.nextInt(24);
        int start_minutes = r.nextInt(60);

        Calendar calendar = new GregorianCalendar(start_year, start_mouth, start_day, start_hour, start_minutes);
        Date start_date = calendar.getTime();
        calendar.add(Calendar.HOUR, r.nextInt(8));
        Date end_date = calendar.getTime();
        return new Pair<>(start_date, end_date);
    }

    public List<CarOwner> listRepair(List<CarOwner> carOwners, CarRepository carRepository, DriverRepository driverRepository){
        int count = (int)(carOwners.size()/carRepository.count());
        return generate(count, carRepository, driverRepository);
    }
}
