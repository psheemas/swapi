package com.work.job.swapi.client;

import com.work.job.domain.SwapiFilmsDto;
import com.work.job.domain.SwapiGeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;


@Component
public class SwapiClient {

    @Value("${swapi.api.endpoint.prod}")
    private String swapiApiEndpoint;

    @Autowired
    private RestTemplate restTemplate;
/*
    public List<SwapiFilmsDto> getListOfFilms() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla");
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<List<SwapiFilmsDto>> response = restTemplate.exchange("https://swapi.co/api/films", HttpMethod.GET, entity, new ParameterizedTypeReference<List<SwapiFilmsDto>>() {
        });

        List<SwapiFilmsDto> responsuuu = response.getBody();
        return responsuuu;
    }

 */
    public SwapiGeneralResponse getListOfFilms(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla");
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<SwapiGeneralResponse> response = restTemplate.exchange("https://swapi.co/api/films", HttpMethod.GET, entity,SwapiGeneralResponse.class);

        return response.getBody();
    }
}
