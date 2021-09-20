package com.pavelkostal.frontendForCloud.controller;

import com.pavelkostal.frontendForCloud.configuration.Configuration;
import com.pavelkostal.frontendForCloud.entity.Employee;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class PageController {

    private Logger logger = LoggerFactory.getLogger(PageController.class);
    
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final Configuration configuration;
    private BackendProxy backendproxy;
    
    private final String employeesUrl = "http://localhost:8000/api/v1/employees";
    private final String employeesUrlWithFlux = "http://localhost:8000/api/v2/employees";

    @Autowired
    public PageController(RestTemplate restTemplate, Configuration configuration, BackendProxy backendproxy) {
        this.restTemplate = restTemplate;
        this.configuration = configuration;
        this.backendproxy = backendproxy;
        webClient = WebClient.create();
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
    
    @GetMapping("/fluxAndWebclient")
    public List<Employee> connectToRestBackendWithFluxAndWebClient() {

        // just for testing if config cloud server works
        configuration.getMaximum();
        configuration.getMinimum();

        return webClient.get().uri(employeesUrlWithFlux)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }

    @GetMapping("/fluxAndWebclientAndFeign")
    @Retry(name = "default", fallbackMethod = "hardcodedResponse")
    public List<Employee> connectToRestBackendWithFluxAndWebClientAndFeign() {


        return backendproxy.connectToRestBackendWithFluxAndWebClientAndFeignClient();
    }

    public List<Employee> hardcodedResponse(Exception ex) {
        return List.of(new Employee("not found", -1, "0"));
    }
}
