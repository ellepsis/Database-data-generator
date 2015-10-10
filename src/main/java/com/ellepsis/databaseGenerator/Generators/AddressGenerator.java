package com.ellepsis.databaseGenerator.Generators;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gysevvlad on 10.10.2015.
 */
public class AddressGenerator {
    private ArrayList<String> streets = new ArrayList<>();
    private Random random = new Random();

    public AddressGenerator(String path) throws FileNotFoundException, IOException {
        FileInputStream fileReader = new FileInputStream ( path );
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileReader,"UTF-8"));
        String tmp;
        reader.readLine();
        reader.readLine();
        while(( reader.readLine() ) != null ) {
            reader.readLine();
            tmp = reader.readLine();
            streets.add(tmp.substring(8));
        }
        reader.close();
        fileReader.close();
    }

    public String generateAddress() {
        int i = random.nextInt(streets.size());
        String address;
        address = streets.get( i ) + ", дом №" + random.nextInt(100);
        if (random.nextInt(10) > 5) {
            address += ", подъезд №" + random.nextInt(10);
        }
        return address;
    }

    public ArrayList<String> generateAddresses( int count ) {
        ArrayList<String> addresses = new ArrayList<>();
        for( int i = 0; i < count; i++ ) {
            addresses.add( generateAddress() );
        }
        return addresses;
    }
}
