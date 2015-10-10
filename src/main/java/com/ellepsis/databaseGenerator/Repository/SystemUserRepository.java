package com.ellepsis.databaseGenerator.Repository;

import com.ellepsis.databaseGenerator.Entity.PermissionType;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by EllepsisRT on 08.10.2015.
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
}
