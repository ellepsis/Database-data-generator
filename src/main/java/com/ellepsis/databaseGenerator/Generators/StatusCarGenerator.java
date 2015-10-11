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
        status0.setDescription("services");
        states.add( status0 );

        StatusCar status1 = new StatusCar();
        status1.setDescription("waits");
        states.add( status1 );

        StatusCar status2 = new StatusCar();
        status2.setDescription("repaired");
        states.add( status2 );

        StatusCar status3 = new StatusCar();
        status3.setDescription("broken");
        states.add( status3 );
    }

    public StatusCar generateStatusCar() {
        int p = random.nextInt(100);
        //if ( p < 10 ) return states.get(1);
        if ( p < 80 ) return states.get(0);
        if ( p < 95 ) return states.get(2);
        return states.get(3);
    }

    public ArrayList<StatusCar> generateStatesCar() {
        return states;
    }
}
