package com.example.demo.services;

import com.example.demo.Database;
import com.example.demo.exceptions.MyException;
import com.example.demo.model.Relationship;
import lombok.var;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelationshipService {
    public static List<Relationship> relationshipList = new ArrayList<>();

    public static void addRelationship(String relationshipId, String firstId, String secondId) {
        relationshipList.add(new Relationship(relationshipId, firstId, secondId));
        Connection connection = Database.getConnection();
        try {
            var statement = connection.prepareStatement("INSERT INTO relationships VALUES (?,?,?)");
            statement.setString(1, relationshipId);
            statement.setString(2, firstId);
            statement.setString(3, secondId);
            statement.executeQuery();
        } catch (SQLException exception) {
            System.out.println("Exception in addRelationship method.");
        }
    }

    public static void addRelationship(Relationship relationship) {
        relationshipList.add(relationship);
        Connection connection = Database.getConnection();
        try {
            var statement = connection.prepareStatement("INSERT INTO relationships VALUES (?,?,?)");
            statement.setString(1, relationship.getRelationshipId());
            statement.setString(2, relationship.getFirstPersonId());
            statement.setString(3, relationship.getSecondPersonId());
            statement.executeQuery();
        } catch (SQLException exception) {
            System.out.println("Exception in addRelationship method.");
        }
    }

    public static void updateRelationship(String firstId, String secondId) {
        var connection = Database.getConnection();
        for (Relationship relationship : relationshipList) {
            if (relationship.getRelationshipId().equals(firstId)) {
                relationship.setSecondPersonId(secondId);
                break;
            }
        }
        try {
            var statement = connection.prepareStatement("UPDATE relationships SET SECOND_PERSON_ID=? WHERE FIRST_PERSON_ID=?");
            statement.setString(1, secondId);
            statement.setString(2, firstId);
            statement.executeQuery();
        } catch (SQLException exception) {
            System.out.println("Exception in updateRelationship method.");
        }
    }

    public static void deleteRelationship(String relationshipId) {
        var connection = Database.getConnection();
        try {
            var statement = connection.prepareStatement("DELETE FROM relationships WHERE ID_RELATIONSHIP=?");
            statement.setString(1, relationshipId);
            statement.executeQuery();
            relationshipList.removeIf(relationship -> relationship.getRelationshipId().equals(relationshipId));
        } catch (SQLException exception) {
            System.out.println("Exception in deleteRelationship method.");
        }
    }

    public static List<Relationship> showList() throws MyException {
        if (relationshipList.size() > 0) {
            return relationshipList;
        } else {
            throw new MyException("The table is empty.");
        }
    }
}
