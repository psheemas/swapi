package com.work.job.swapi.client;

import com.work.job.domain.SwapiFilmsWrapper;
import com.work.job.domain.SwapiPeopleWrapper;
import com.work.job.domain.SwapiPlanetsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SwapiClient {

    @Value("${swapi.api.endpoint.prod}")
    private String swapiApiEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public SwapiFilmsWrapper getListOfFilms(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla");
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<SwapiFilmsWrapper> response = restTemplate.exchange("https://swapi.co/api/films", HttpMethod.GET, entity, SwapiFilmsWrapper.class);

        return response.getBody();
    }

    public SwapiPeopleWrapper searchPeople(String character_phrase){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla");
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<SwapiPeopleWrapper> response = restTemplate.exchange("https://swapi.co/api/people/?search=" + character_phrase, HttpMethod.GET, entity, SwapiPeopleWrapper.class);

        return response.getBody();
    }

    public SwapiPlanetsWrapper searchPlanets(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla");
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<SwapiPlanetsWrapper> response = restTemplate.exchange("https://swapi.co/api/planets", HttpMethod.GET, entity, SwapiPlanetsWrapper.class);

        return response.getBody();
    }
}
