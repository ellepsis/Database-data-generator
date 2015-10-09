package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
}
