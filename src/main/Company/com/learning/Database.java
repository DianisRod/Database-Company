package com.learning;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datenbank {

    public static Connection dbConnection( ){
        String sqlUsername ="Admin";
        String sqlPasswort = "LFhkrDabldN]a5m[";
        String sqlUrl = "jdbc:mysql//localhost:3306/company";
        try {
            Class.forName("mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPasswort);
            return conn;
        }
        catch (SQLException|ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
