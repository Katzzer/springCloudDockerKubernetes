package com.pavelkostal.backendForCloud.controller;

import com.pavelkostal.backendForCloud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/")
public class RestController {
    
    @GetMapping("v1/employees")
    public List<Employee> employeeList() {
        List<Employee> listOfEmployees = List.of(
                new Employee("Pavel", 41),
                new Employee("Adelka", 2)
        );

        return listOfEmployees;
    }

    @GetMapping("v2/employees")
    public Mono<List<Employee>> employeeListWithFlux() {
        List<Employee> listOfEmployees = List.of(
                new Employee("Pavel", 41),
                new Employee("Adelka", 2));
        return Mono.just(listOfEmployees);
    }

}
