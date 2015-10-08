package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.ClientPhone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface ClientPhoneRepository extends JpaRepository<ClientPhone, Long> {
    
}
