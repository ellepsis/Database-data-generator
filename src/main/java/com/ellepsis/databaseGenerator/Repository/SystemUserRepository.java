package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
}
