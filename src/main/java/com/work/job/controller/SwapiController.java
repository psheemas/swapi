package com.work.job.controller;

import com.work.job.domain.SwapiFilmsDto;
import com.work.job.swapi.client.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1/swapi")
public class SwapiController {

    @Autowired
    private SwapiClient swapiClient;

    @RequestMapping(method = RequestMethod.GET, value = "getFilms")

    public void getFilms(){
        System.out.println(swapiClient.getListOfFilms().getResults().get(0).getTitle());
        swapiClient.getListOfFilms().getResults().stream()
                .forEach(a-> System.out.println(a.getTitle()));

    }
/*
    public void getFilms(){
        System.out.println(swapiClient.getListOfFilms().get(0).getTitle());
    }

 */
}
