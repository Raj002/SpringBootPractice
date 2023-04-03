package com.practice.rest.webservices.restwebservices.pojos;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private Integer id;

    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    @Past(message = "Birth date should be always past date")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

}
