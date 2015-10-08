package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}
