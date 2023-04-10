package com.practice.rest.webservices.restwebservices.apis;

import com.practice.rest.webservices.restwebservices.pojos.Name;
import com.practice.rest.webservices.restwebservices.pojos.Person1;
import com.practice.rest.webservices.restwebservices.pojos.Person2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResources {

    @GetMapping(path = "/person", params = "version=1.0")
    //@GetMapping(path = "/person", headers = "X-API-VERSION=1.0")
    public Person1 person1Name() {
        return new Person1("John");
    }

    //@GetMapping(path = "/person", params = "version=1.1")
    @GetMapping(path = "/person", headers = "X-API-VERSION=1.1")
    public Person2 person2Name() {
        return new Person2(new Name("Williams", "User 123"));
    }


    @GetMapping(path = "/person", produces = "application/vpn.rakuten.rpay")
    public Person1 person1NameWithVersion() {
        return new Person1("Produces version");
    }


}
