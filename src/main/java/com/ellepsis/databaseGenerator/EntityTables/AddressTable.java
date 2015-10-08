package com.ellepsis.databaseGenerator.EntityTables;

import com.ellepsis.databaseGenerator.Entity.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EllepsisRT on 07.10.2015.
 */
public class AddressTable implements EntityTable{

    private final String tableType = this.getClass().getName();
    List<Address> entities = new ArrayList<>();

    @Override
    public String getTableType() {
        return tableType;
    }

    @Override
    public int getEntitiesCount() {
        return entities.size();
    }
}
