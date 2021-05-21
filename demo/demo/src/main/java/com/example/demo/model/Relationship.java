package com.example.demo.model;

import lombok.Data;

@Data
public class Relationship {
    private String relationshipId;
    private String firstPersonId;
    private String secondPersonId;

    public Relationship(String relationshipId, String firstPersonId, String secondPersonId) {
        this.relationshipId = relationshipId;
        this.firstPersonId = firstPersonId;
        this.secondPersonId = secondPersonId;
    }
}
