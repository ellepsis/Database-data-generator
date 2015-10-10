package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.PermissionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class PermissionTypeGenerator {
    Random r = new Random();
    public List<PermissionType> generatePermissionTypes(){
        List<PermissionType> permissionTypes = new ArrayList<>();

        PermissionType permissionType = new PermissionType();
        permissionType.setPermission(r.nextLong());
        permissionType.setDescription("Director's permissions");
        permissionTypes.add(permissionType);

        permissionType = new PermissionType();
        permissionType.setPermission(0L);
        permissionType.setDescription("Null permission");
        permissionTypes.add(permissionType);

        permissionType = new PermissionType();
        permissionType.setPermission(r.nextLong());
        permissionType.setDescription("Driver's permissions");
        permissionTypes.add(permissionType);

        permissionType = new PermissionType();
        permissionType.setPermission(r.nextLong());
        permissionType.setDescription("Dispatcher's permissions");
        permissionTypes.add(permissionType);

        permissionType = new PermissionType();
        permissionType.setPermission(r.nextLong());
        permissionType.setDescription("Cleaner's permissions");
        permissionTypes.add(permissionType);

        permissionType = new PermissionType();
        permissionType.setPermission(r.nextLong());
        permissionType.setDescription("Manager's permissions");
        permissionTypes.add(permissionType);

        return permissionTypes;
    }
}
