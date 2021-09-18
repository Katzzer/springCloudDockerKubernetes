package com.pavelkostal.frontendForCloud.controller;

import com.pavelkostal.frontendForCloud.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PageController {

    private Logger logger = LoggerFactory.getLogger(PageController.class);
    
    private RestTemplate restTemplate;
    
    private final String employeesUrl = "http://localhost:8000/api/v1/employees";
    private final String employeesUrlWithFlux = "http://localhost:8000/api/v2/employees";

    public PageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public List<Employee> connectToRestBackend() {

        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(employeesUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();

    }

    @GetMapping("/flux")
    public List<Employee> connectToRestBackendWithFlux() {

        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(employeesUrlWithFlux, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();

    }
}
