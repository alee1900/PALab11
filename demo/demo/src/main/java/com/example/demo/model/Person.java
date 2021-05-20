package com.example.demo.model;

import lombok.Data;

/**
 * Person class
 */
@Data
public class Person{

    private final String id;
    private String name;

    public Person(String id, String name) {
        this.id=id;
        this.name=name;
    }
}