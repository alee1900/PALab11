package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for database connection
 */
public class Database {
    public ResultSet resultSet;
    private Connection connection;

    private static final Database instance = new Database();

    public static Database getInstance() {
        return instance;
    }

    private Database() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "student");
        } catch (Exception exception) {
            System.out.println("Error connecting to the database.");
        }
    }

    /**
     * Method for executing a query
     * @param query represents the query
     * @return the result of the query
     */
    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception exception) {
            System.out.println("Error executing query.");
        }
        return resultSet;
    }

    /**
     * Method for updating the database
     * @param update represents the update required
     */
    public void update(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (Exception exception) {
            System.out.println("Error updating database.");
        }
    }
}
