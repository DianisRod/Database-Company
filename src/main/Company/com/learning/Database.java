package com.learning;

import java.sql.*;

public class Database {

    public static Connection dbConnection( ){
        String sqlUsername ="Admin";
        String sqlPasswort = "LFhkrDabldN]a5m[";
        String sqlUrl = "jdbc:mysql://localhost:3306/companytest";
        //String sqlUrl = "jdbc:mysql://localhost:3306/companytest?useSSL=false&allowPublicKeyRetrieval=true";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPasswort);
            System.out.println("✅ Successfully connection!");
            Statement statement = conn.createStatement();
            String sql = "SELECT C.firstName, C.lastName, C.age, C.email, S.annualSalary, S.Bonus " +
                    "FROM company C JOIN Salary S ON S.PerNr = C.PerNr";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " years old, " + " win on a year " + rs.getInt(5) + " Extra Bonus " + rs.getInt(6));
            }
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

    //run the command
    //  mysql -u Admin -p
    //  USE companytest
    //  SHOW TABLES;
}
