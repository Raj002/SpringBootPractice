package com.practice.rest.webservices.restwebservices.pojos;

import lombok.Data;

@Data
public class Person2 {
    private Name name;

    public Person2(Name name) {
        this.name = name;
    }
}
