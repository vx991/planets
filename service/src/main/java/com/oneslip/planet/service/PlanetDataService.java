package com.oneslip.planet.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneslip.planet.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetDataService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${planet.data.url}")
    private String planetDataUrl;

    public PlanetDataService() {
    }

    public List<Planet> getPlanetData() throws IOException {
        List<Planet> planetData = new ArrayList<>();

        String result = restTemplate.getForObject(planetDataUrl, String.class);

        if (result != null) {
            planetData = new ObjectMapper().readValue(result, new TypeReference<List<Planet>>(){});
        }

        return planetData;
    }

}
