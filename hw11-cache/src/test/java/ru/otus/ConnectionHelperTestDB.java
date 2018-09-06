package ru.otus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelperTestDB {

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());

            String url = "jdbc:h2:mem:test";


            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
