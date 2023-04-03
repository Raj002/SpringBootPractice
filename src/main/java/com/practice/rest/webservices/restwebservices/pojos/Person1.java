package com.practice.rest.webservices.restwebservices.pojos;

import lombok.Data;

@Data
public class Person1 {
    private String name;
    public Person1(String name) {
        this.name = name;
    }
}
