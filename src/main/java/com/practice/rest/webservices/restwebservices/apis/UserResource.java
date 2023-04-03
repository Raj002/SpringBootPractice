package com.practice.rest.webservices.restwebservices.apis;

import com.practice.rest.webservices.restwebservices.dao.UserDaoService;
import com.practice.rest.webservices.restwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.practice.rest.webservices.restwebservices.pojos.User;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {

    private final UserDaoService userDaoService;
    private final MessageSource messageSource;

    public UserResource(UserDaoService userDaoService, MessageSource messageSource) {
        this.userDaoService = userDaoService;
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/users")
    public List<User> userList() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User user(@PathVariable int id) throws UserNotFoundException {
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id : " + id);
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        if (user == null)
            throw new UserNotFoundException("Id : " + id);

        userDaoService.deleteUserById(id);
    }

    @GetMapping(path = "/hello")
    public String internalisation(){

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Provide valid language in headers", locale);
    }


}
