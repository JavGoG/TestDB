package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        /*
        Connecting and creating a local data base on Windows computer and
        Try with Resources to close automatically our resources
        */

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Rosana&Javier\\databases\\testjava.db");
             Statement statement = conn.createStatement()) {

            //conn.setAutoCommit(false); by default is set to true

            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    "(name TEXT, phone INTEGER, email TEXT)");
     /*     statement.execute("INSERT INTO contacts (name, phone, email)" +
                                "VALUES ('Juan', 677345718, 'juan@gmail.com')");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                    "VALUES ('John', 677256718, 'john@gmail.com')");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                    "VALUES ('Jane', 67123456, 'jane@gmail.com')");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                    "VALUES ('Jude', 67654321, 'jude@gmail.com')");
*/
           /* statement.execute("UPDATE contacts SET phone = 5555555 WHERE name = 'Javier'");
            statement.execute("DELETE FROM contacts WHERE name = 'John'");*/

            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }
            results.close(); // ResultSet is a Resource and must be closed

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
