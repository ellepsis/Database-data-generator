package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Car;
import com.ellepsis.databaseGenerator.Entity.ClientType;
import com.ellepsis.databaseGenerator.Entity.StatusCar;
import com.ellepsis.databaseGenerator.Repository.CarRepository;
import com.ellepsis.databaseGenerator.Repository.StatusCarRepository;

import javax.validation.constraints.Null;
import java.io.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gysevvlad on 11.10.2015.
 */
public class CarGenerator {

    ArrayList<String> tmp_cars = new ArrayList<>();
    Random random = new Random();

    public CarGenerator(String path) throws IOException {
        FileInputStream fileReader = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileReader, "UTF-8"));

        while (reader.readLine() != null) {
            String brand_model = reader.readLine().replaceAll("<.+?>", "");
            tmp_cars.add(brand_model);
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
        }
        reader.close();
        fileReader.close();
    }

    public Car generateCar() {

        Car car = new Car();
        String letters = "АВЕКМНОРСТУХ";
        String digits = "0987654321";

        String brand_and_mark = tmp_cars.get(random.nextInt(tmp_cars.size()));
        int splitIndex = brand_and_mark.indexOf(" ");
        car.setBrand(brand_and_mark.substring(0, splitIndex));
        car.setModel(brand_and_mark.substring(splitIndex + 1));

        car.setReleaseYear(2000 + random.nextInt(15) + "");

        car.setGovernmentNumber(new String(new char[]{
                letters.charAt(random.nextInt(letters.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                letters.charAt(random.nextInt(letters.length())),
                letters.charAt(random.nextInt(letters.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length()))}
        ));

        car.setVIN(new String(new char[]{
                letters.charAt(random.nextInt(letters.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                letters.charAt(random.nextInt(letters.length())),
                letters.charAt(random.nextInt(letters.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                letters.charAt(random.nextInt(letters.length())),
                letters.charAt(random.nextInt(letters.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                letters.charAt(random.nextInt(letters.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length()))
        }));

        car.setInsuranceNumber(new String(new char[]{
                'E',
                'E',
                'E',
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length())),
                digits.charAt(random.nextInt(digits.length()))
        }));

        return car;
    }

    public ArrayList<Car> generateCars(StatusCarRepository stateCarsRepository, int count) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(generateCar());
        }
        listRepair(cars, stateCarsRepository);
        return cars;
    }

    public void listRepair(List<Car> cars, StatusCarRepository stateCarsRepository) {
        List<StatusCar> stateCars = stateCarsRepository.findAll();
        cars.stream().forEach(o -> o.setStatusCarId(stateCars.get(random.nextInt(stateCars.size()))));
    }
}
