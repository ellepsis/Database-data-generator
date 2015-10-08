package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.StatusCar;
import com.ellepsis.databaseGenerator.Entity.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface StatusCarRepository extends JpaRepository<StatusCar, Long> {
}
