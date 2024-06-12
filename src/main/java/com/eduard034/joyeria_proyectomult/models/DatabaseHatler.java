package com.eduard034.joyeria_proyectomult.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHatler {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "quesobadin";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
}
