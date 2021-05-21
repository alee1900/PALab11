package com.example.demo.services;

import com.example.demo.Database;
import com.example.demo.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for person database services
 */
public class PersonService {
    private static final Database db = Database.getInstance();
    private static final List<Person> personList = new ArrayList<>();

    /**
     * Method for adding a person in the database by id and name
     * @param id represents the id of the person to be added
     * @param name represents the name of the person to be added
     * @return response
     */
    public static String addPersonByName(String id, String name) {
        String query = "INSERT INTO persons(id, name) VALUES('" + id + "','" + name + "')";
        db.update(query);
        personList.add(new Person(id, name));
        return name + " has been added to the list.";
    }

    /**
     * Method for adding a person in the database
     * @param person represents the person to be added
     * @return response
     */
    public static String addPerson(Person person) {
        String query = "INSERT INTO persons(id, name) VALUES('" + person.getId() + "','" + person.getName() + "')";
        db.update(query);
        personList.add(new Person(person.getId(), person.getName()));
        return person.getName() + " has been added to the database.";
    }

    /**
     * Method for updating the name of a person in the database
     * @param id represents the name of the person
     * @param newName represents the new name
     * @return response
     */
    public static String updatePerson(String id, String newName) {
        String query = "UPDATE persons SET name= '" + newName + "' WHERE id='" + id + "'";
        db.update(query);
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                person.setName(newName);
                break;
            }
        }
        return "Person was updated.";
    }

    /**
     * Method for deleting a person from the database
     * @param id represents the id of the person to be deleted
     * @return response
     */
    public static String deletePerson(String id) {
        String query = "DELETE FROM persons WHERE id='" + id + "'";
        db.update(query);
        for(int i=0;i<personList.size();i++){
            if(personList.get(i).getId().equals(id)){
                personList.remove(i);
                return "The person has been deleted successfully";
            }
        }
        return "The person with the id " + id + " was not found";
    }

    /**
     * Method for searching for a person in the database and getting their info
     * @param id represents the id of the person
     * @return the person
     */
    public static Person getPersonInfo(int id) {
        Person person = null;
        ResultSet resultSet = db.executeQuery("SELECT id, name FROM persons WHERE id= " + id + "'");
        try {
            while (resultSet.next()) {
                person = new Person(resultSet.getString(1), resultSet.getString(2));
            }
        } catch (SQLException exception) {
            System.out.println("Player not found.");
        }
        return person;
    }

    /**
     * Method for getting the list of persons from the database
     * @return the list of persons
     */
    public static List<Person> getPersonList() {
        ResultSet resultSet = db.executeQuery("SELECT id, name FROM persons");
        try {
            while (resultSet.next()) {
                Person person = new Person(resultSet.getString(1), resultSet.getString(2));
                personList.add(person);
            }
        } catch (Exception exception) {
            System.out.println("The table is empty.");
        }
        return personList;
    }
}