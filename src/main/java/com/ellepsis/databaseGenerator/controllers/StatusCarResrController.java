package com.ellepsis.databaseGenerator.controllers;

import com.ellepsis.databaseGenerator.Entity.StatusCar;
import com.ellepsis.databaseGenerator.Repository.StatusCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gysevvlad on 11.10.2015.
 */
@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatusCarResrController {
    @Autowired
    StatusCarRepository statusCarRepository;

    @RequestMapping(value="/getStatesCar", method = RequestMethod.GET, headers="Accept=application/json")
    public List<StatusCar> getAll() {
        return statusCarRepository.findAll();
    }
}
