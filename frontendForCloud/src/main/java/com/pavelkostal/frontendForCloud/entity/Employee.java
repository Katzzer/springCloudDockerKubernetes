package com.pavelkostal.frontendForCloud.entity;

import lombok.*;

public class Employee {
    
    private String name;
    private int age;

    public Employee(int age) {
        this.age = age;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
