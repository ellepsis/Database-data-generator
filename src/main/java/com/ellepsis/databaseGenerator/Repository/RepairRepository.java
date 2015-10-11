package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.CarRepair;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface RepairRepository extends JpaRepository<CarRepair, Long> {
}
