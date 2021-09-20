package com.pavelkostal.backendForCloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    
    private String name;
    private int age;
    private String environment;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
