package com.work.job.controller;

import com.work.job.swapi.client.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
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
        swapiClient.getListOfFilms().getResults().stream()
                .forEach(a-> System.out.println(a.getTitle()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "getPeople")
    public void serchPeople(@RequestHeader String controller_character_phrase){
        swapiClient.searchPeople(controller_character_phrase).getResults()
                .stream()
                .forEach(b-> System.out.println(b.getName()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getPlanets")
    public void searchPlanets(){
        swapiClient.searchPlanets().getResults()
                .stream()
                .forEach(b-> System.out.println(b.getName()));
    }
}
