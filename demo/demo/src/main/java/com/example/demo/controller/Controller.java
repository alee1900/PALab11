package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.services.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * REST controller for person
 */
@RestController
@RequestMapping("/persons")
public class Controller {
    static List<Person> personList = new ArrayList<>();

    public Controller() {
    }

    /**
     * Method for obtaining the list of persons
     * Uses HTTP GET request
     * @return the list of persons
     */
    @GetMapping
    public List<Person> getPersonList() {
        return Service.getPersonList();
    }

    /**
     * Method for adding a new person in the database
     * Uses HTTP POST request
     * @param name represents the name of the person to be added
     * @return response
     */
    @PostMapping
    public ResponseEntity<String> addPerson(@RequestParam("name") String name) {
        Random rand = new Random();
        String id = String.valueOf(rand.nextInt(9999));
        personList.add(new Person(id, name));
        Service.addPersonByName(id, name);
        return new ResponseEntity<>("Person added successfully to the database.", HttpStatus.CREATED);
    }

    /**
     * Method for adding a new person in the database
     * Uses HTTP POST request
     * @param person represents the person to be added
     * @return response
     */
    @PostMapping(value = "/create", consumes = "application/json")
    public static ResponseEntity<String> addPerson(@RequestBody Person person) {
        ResponseEntity<String> anotherPerson = Controller.addPerson(person);
        personList.add(person);
        return new ResponseEntity<>(String.valueOf(anotherPerson), new HttpHeaders(), HttpStatus.CREATED);
    }

    /**
     * Method for modifying the name of a person
     * Uses HTTP PUT request
     * @param id represents the id of the person
     * @param name represents the name of the person
     * @return response
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable String id, @RequestParam("name") String name) {
        Service.updatePerson(id, name);
        return new ResponseEntity<>("Person's name updated successfully.", HttpStatus.OK);
    }

    /**
     * Method for deleting a person
     * Uses HTTP DELETE request
     * @param id represents the id of the person to be deleted
     * @return response
     */
    @DeleteMapping(value = "/{id}")
    public static ResponseEntity<String> deletePerson(@PathVariable String id) {
        ResponseEntity<String> response = Controller.deletePerson(id);
        return new ResponseEntity<>(String.valueOf(response), new HttpHeaders(), HttpStatus.OK);
    }
}
