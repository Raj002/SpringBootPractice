package com.practice.rest.webservices.restwebservices.pojos;

import lombok.Data;

@Data
public class Name {
    private String firstName;
    private String secondName;

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
