package org.example;

import java.sql.*;
import java.util.ArrayList;

//mysql database
//take the names and surnames of all the students (using ResultSet and its .next() method) and:
//        print the names on screen while executing the query
//        assign the surnames to an ArrayList called surnames
//        once the query is completed, print all the surnames
public class Database {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Develhope",
                    "root", ",$rZ8JgBeUbR#cw");

            Statement statement = connection.createStatement();

            ResultSet fullNames = statement.executeQuery("SELECT first_Name, last_Name FROM students");

            ArrayList<String> surnames = new ArrayList<>();
            while (fullNames.next()) {
                String firstName = fullNames.getString("first_Name");
                String lastName = fullNames.getString("last_Name");
                System.out.println(firstName + " " + lastName);
                //aggiungo i lastName alla lista surnames
                surnames.add(lastName);
            }
            System.out.println("Surnames:");
            for (String surname : surnames) {
                System.out.println(surname);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}