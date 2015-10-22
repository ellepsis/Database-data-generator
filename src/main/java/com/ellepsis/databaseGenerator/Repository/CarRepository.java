package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Car;
import com.ellepsis.databaseGenerator.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

}
