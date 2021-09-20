package com.pavelkostal.backendForCloud.controller;

import com.pavelkostal.backendForCloud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/")
public class RestController {
    
    @Autowired
    private Environment environment;
    
    @GetMapping("v1/employees")
    public List<Employee> employeeList() {
        return getListOfEmployees();
    }

    @GetMapping("v2/employees")
    public Mono<List<Employee>> employeeListWithFlux() {
        return Mono.just(getListOfEmployees());
    }
    
    public List<Employee> getListOfEmployees() {
        return List.of(
                new Employee("Pavel", 42, environment.getProperty("local.server.port")),
                new Employee("Adelka", 2, environment.getProperty("local.server.port")));
    }

}
