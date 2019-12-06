package com.whistle.needhi.controller;

import com.whistle.needhi.dto.PersonDTO;
import com.whistle.needhi.model.Person;
import com.whistle.needhi.service.PersonRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonRegistrationController {
    @Autowired
    PersonRegistrationService personService;

    private static final String URL_PREFIX = "/v1/User";
    private static final String User_ID = "/{UserID}";

    @GetMapping("/")
    public String welcome() {
        return "Hello World";
    }

    @GetMapping(value = URL_PREFIX)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllUsers() {
        return personService.getAllPeople();
    }

    @GetMapping(value = URL_PREFIX + User_ID)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Person> getUserById(@PathVariable("UserID") long id) {
        return personService.getPerson(id);
    }

    @DeleteMapping(value = URL_PREFIX + User_ID)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("UserID") long id) {
        personService.delete(id);
    }

    @PostMapping(value = URL_PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, URI>> saveUser(@RequestBody PersonDTO user) {
        long UserID = personService.saveOrUpdate(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(User_ID).buildAndExpand(UserID)
                .toUri();
        return ResponseEntity.created(location)
                .body(Collections.singletonMap("User successfully got created", location));
    }
}
