package com.ellepsis.databaseGenerator.controllers;

import com.ellepsis.databaseGenerator.Entity.Client;
import com.ellepsis.databaseGenerator.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by EllepsisRT on 09.10.2015.
 */
@RestController
@RequestMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientsRestController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value="/getClients", method = RequestMethod.GET, headers="Accept=application/json")
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
