package com.example.demo.controller;

import com.example.demo.exceptions.MyException;
import com.example.demo.model.Relationship;
import com.example.demo.services.RelationshipService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {
    @GetMapping
    public List<Relationship> getRelationship() throws MyException {
        return RelationshipService.showList();
    }

    @GetMapping("/{relationshipId}")
    public Relationship getRelationship(@PathVariable String relationshipId) throws MyException {
        for (int i = 0; i < RelationshipService.relationshipList.size(); i++) {
            if (RelationshipService.relationshipList.get(i).getRelationshipId().equals(relationshipId)) {
                return RelationshipService.relationshipList.get(i);
            }
        }
        throw new MyException("Not found");
    }

    @GetMapping("/count")
    public static int getCountRelationships() {
        return RelationshipService.relationshipList.size();
    }

    @PostMapping("/{firstId}/{secondId}")
    public ResponseEntity<String> updateRelationship(@PathVariable("firstId") String firstId, @PathVariable("secondId") String secondId) {
        RelationshipService.updateRelationship(firstId, secondId);
        return new ResponseEntity<>("Relationship updated successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/{firstId}/{secondId}")
    public ResponseEntity<String> addRelationship(@PathVariable("firstId") String firstId, @PathVariable("secondId") String secondId) {
        String relationshipId = String.valueOf(RelationshipService.relationshipList.size());
        RelationshipService.addRelationship(relationshipId, firstId, secondId);
        return new ResponseEntity<>("Relationship added successfully.", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{relationshipId}")
    public static ResponseEntity<String> deleteRelationship(@PathVariable String relationshipId) {
        RelationshipService.deleteRelationship(relationshipId);
        return new ResponseEntity<>("Relationship deleted successfully.", new HttpHeaders(), HttpStatus.OK);
    }
}
