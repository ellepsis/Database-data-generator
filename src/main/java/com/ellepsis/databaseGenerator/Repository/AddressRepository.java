package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Address;
import com.ellepsis.databaseGenerator.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
