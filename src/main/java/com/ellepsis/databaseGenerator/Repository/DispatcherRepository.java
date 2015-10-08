package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.Dispatcher;
import com.ellepsis.databaseGenerator.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface DispatcherRepository extends JpaRepository<Dispatcher, Long> {
}
