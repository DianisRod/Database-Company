package com.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection dbConnection( ){
        String sqlUsername ="Admin";
        String sqlPasswort = "LFhkrDabldN]a5m[";
        //String sqlUrl = "jdbc:mysql://localhost:3306/companytest";
        String sqlUrl = "jdbc:mysql://localhost:3306/companytest?useSSL=false&allowPublicKeyRetrieval=true";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPasswort);
            System.out.println("✅ Successfully connection!");
            return conn;
        }
        catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC-Treiber didn't find: " + e.getMessage());
        }
        catch (SQLException e){
            System.err.println("❌ SQL-error: " + e.getMessage());
        }
        return null;
    }
}
