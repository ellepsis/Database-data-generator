package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.StatusCar;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gysevvlad on 11.10.2015.
 */
public class StatusCarGenerator {
    ArrayList<StatusCar> states = new ArrayList<>();
    Random random = new Random();

    public StatusCarGenerator() {
        StatusCar status0 = new StatusCar();
        status0.setDescription("Ожидает");
        states.add(status0);

        StatusCar status1 = new StatusCar();
        status1.setDescription("В пути на заказ");
        states.add(status1);

        StatusCar status2 = new StatusCar();
        status2.setDescription("В процессе заказа");
        states.add(status2);

        StatusCar status3 = new StatusCar();
        status3.setDescription("Возвращается в парк");
        states.add(status3);

        StatusCar status4 = new StatusCar();
        status4.setDescription("Сломалась");
        states.add(status4);
    }

    public StatusCar generateStatusCar() {
        int p = random.nextInt(100);
        if ( p < 10 ) return states.get(1);
        else if (p < 60) return states.get(0);
        else if (p < 85) return states.get(2);
        else if (p < 98) return states.get(3);
        return states.get(4);
    }

    public ArrayList<StatusCar> generateStatesCar() {
        return states;
    }
}
