package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by EllepsisRT on 22.11.2015.
 */
@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
}
