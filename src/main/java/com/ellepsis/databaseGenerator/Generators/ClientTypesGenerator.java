package com.ellepsis.databaseGenerator.Generators;

import com.ellepsis.databaseGenerator.Entity.ClientType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by EllepsisRT on 10.10.2015.
 */
public class ClientTypesGenerator {
    public List<ClientType> generateClientType() {
        ClientType clientType1 = new ClientType();
        clientType1.setDescription("regular");
        clientType1.setDiscount(10);

        ClientType clientType2 = new ClientType();
        clientType2.setDescription("special");
        clientType2.setDiscount(20);

        ClientType clientType3 = new ClientType();
        clientType3.setDescription("new");
        clientType3.setDiscount(0);

        ClientType clientType4 = new ClientType();
        clientType4.setDescription("free");
        clientType4.setDiscount(100);

        return Arrays.asList(
                clientType1,
                clientType2,
                clientType3,
                clientType4
        );
    }
}
