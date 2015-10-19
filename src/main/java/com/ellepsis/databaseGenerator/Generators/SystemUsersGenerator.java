package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Entity.Employee;
import com.ellepsis.databaseGenerator.Entity.PermissionType;
import com.ellepsis.databaseGenerator.Entity.SystemUser;
import com.ellepsis.databaseGenerator.Repository.EmployeeRepository;
import com.ellepsis.databaseGenerator.Repository.PermissionTypeRepository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class SystemUsersGenerator {

    Random r = new Random();

    public List<SystemUser> systemUsersGenerator(PermissionTypeRepository permissionTypeRepository, int count) throws URISyntaxException {
        List<SystemUser> systemUsers = new ArrayList<>();
        int usersCount = 0;
        for (int i = 0; i <= count / 1000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://mockaroo.com/16b42010/download?count=1000&key=bfda25a0");
            SystemUser[] systemUsersArray = restTemplate.getForObject(uri, SystemUser[].class);
            int k = 0;
            for (int j = systemUsers.size(); j < count; j++) {
                systemUsers.add(systemUsersArray[k++]);
            }
        }
        listRepair(systemUsers, permissionTypeRepository);
        return systemUsers;
    }

    public void listRepair(List<SystemUser> systemUsers, PermissionTypeRepository permissionTypeRepository){
        List<PermissionType> permissionTypes = permissionTypeRepository.findAll();
        PermissionType nullPermissionType = permissionTypes.stream().filter(o -> o.getDescription().contains("Null")).findFirst().get();
        systemUsers.forEach(o -> o.setPermissionsTypeId(nullPermissionType));
    }
}
