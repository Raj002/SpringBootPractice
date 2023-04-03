package com.practice.rest.webservices.restwebservices.apis;

import com.practice.rest.webservices.restwebservices.pojos.Name;
import com.practice.rest.webservices.restwebservices.pojos.Person1;
import com.practice.rest.webservices.restwebservices.pojos.Person2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResource {

    @GetMapping(path = "/v1/person")
    public Person1 person1Name() {
        return new Person1("John");
    }

    @GetMapping(path = "/v2/person")
    public Person2 person2Name() {
        return new Person2(new Name("Williams", "User 123"));
    }


}
