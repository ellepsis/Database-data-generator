package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Driver;
import com.ellepsis.databaseGenerator.Entity.EmployeePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
