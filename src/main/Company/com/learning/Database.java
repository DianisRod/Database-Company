package com.learning;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    //create a singleton instance
    private static Database instance = null;

    //create object connection
    private static Connection connection = null;

    private static final String sqlUsername ="Admin";
    private static final String sqlPasswort = "LFhkrDabldN]a5m[";
    //private static final String sqlUrl = "jdbc:mysql://localhost:3306/companytest";
    private static final String sqlUrl = "jdbc:mysql://localhost:3306/companytest?useSSL=false&allowPublicKeyRetrieval=true";


    //create constructor:
    private Database() throws SQLException{
        init();
    }

    //create a init function
    private void init() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPasswort);
            System.out.println("✅ Successfully connection!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC-Treiber didn't find: " + e.getMessage());
        }
        catch (SQLException e){
            System.err.println("❌ SQL-error: " + e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    //create getInstance function . Inside
    public static Database getInstance() throws SQLException{
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new Database();
            instance.init();
        }
            return  instance;
    }

    //run the command
    //  mysql -u Admin -p
    //  USE companytest
    //  SHOW TABLES;
}
