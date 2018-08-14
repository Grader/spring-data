package com.epam.sprdata.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RESTClientGoods {

    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployees() {
        return restTemplate.getForObject("http://localhost:8080/goods", String.class);
    }
}
