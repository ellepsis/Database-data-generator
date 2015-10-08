package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.EmployeePhone;
import com.ellepsis.databaseGenerator.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface EmployeePhoneRepository extends JpaRepository<EmployeePhone, Long> {
}
