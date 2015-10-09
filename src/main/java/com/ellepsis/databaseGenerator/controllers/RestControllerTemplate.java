package com.ellepsis.databaseGenerator.controllers;

import com.ellepsis.databaseGenerator.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ellepsis.databaseGenerator.helper.DateTimeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by vladislav on 30.09.15.
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerTemplate implements DateTimeHelper {
    @RequestMapping(method = RequestMethod.GET)
    public List<String> hello() {
        List<String> list = new ArrayList<>();
        return Arrays.asList("Hello", ", world 123!");
    }

    @RequestMapping("/date")
    public Date date(@RequestParam @DateTimeFormat(pattern = RU_DATE_FORMAT) Date date) {
        return date;
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void startFieldDB(){
    }
}
