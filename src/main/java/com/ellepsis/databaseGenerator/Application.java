package com.ellepsis.databaseGenerator;

import com.ellepsis.databaseGenerator.Generators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vladislav on 30.09.15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired EveryThingGenerator everyThingGenerator;

    public static void main(String... args)  {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        everyThingGenerator.generate();
    }


}
