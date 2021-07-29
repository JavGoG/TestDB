package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        /*
        Connecting and creating a local data base on Windows computer and
        Try with Resources to close automatically our resources
        */

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Rosana&Javier\\databases\\testjava.db");
             Statement statement = conn.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                                 "(name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                                "VALUES ('Javier', 677256718, 'javier@gmail.com')");



        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
