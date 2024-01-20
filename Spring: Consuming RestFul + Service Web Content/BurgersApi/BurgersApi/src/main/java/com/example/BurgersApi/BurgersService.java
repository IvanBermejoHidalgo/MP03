package com.example.BurgersApi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BurgersService {

    private final String BURGERS_API_URL = "https://burgers-hub.p.rapidapi.com/burgers";
    private final RestTemplate restTemplate;

    public BurgersService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Receta> getRecetas() {
        Receta[] recetasArray = restTemplate.getForObject(BURGERS_API_URL, Receta[].class);
        return Arrays.asList(recetasArray);
    }
}