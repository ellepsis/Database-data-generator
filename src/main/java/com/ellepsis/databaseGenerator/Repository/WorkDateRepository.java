package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.ClientType;
import com.ellepsis.databaseGenerator.Entity.WorkDate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface WorkDateRepository extends JpaRepository<WorkDate, Long> {
}
