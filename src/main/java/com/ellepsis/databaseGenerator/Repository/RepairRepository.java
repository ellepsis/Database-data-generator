package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Repair;
import com.ellepsis.databaseGenerator.Entity.StatusCar;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface RepairRepository extends JpaRepository<Repair, Long> {
}
