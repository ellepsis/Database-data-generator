package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}
