package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Driver;
import com.ellepsis.databaseGenerator.Entity.EmployeePhone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
