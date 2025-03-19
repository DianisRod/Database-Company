package com.learning;

import java.sql.*;


import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    //singleton Instance
    private Database database;
    private Connection connection;
    private List<DataObject> data;


    public DataManager() {
        try {
            database = Database.getInstance();
            connection = database.getConnection();
            data = new ArrayList<>();
        } catch (SQLException e) {
            System.err.println("❌ Failed to initialize Database: " + e.getMessage());
        }
    }

    public void setData(int PerNr, String firstName, String lastName, int age, String email) {
       DataObject newEntry = new DataObject(PerNr, firstName, lastName, age, email);
       data.add(newEntry);
    }

    public void getDataForPerNr() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT PerNr, firstName, lastName, age, email FROM company ";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            setData(rs.getInt("PerNr"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"), rs.getString("email"));
        }
    }

    public void displayData(String value){
        if (data.isEmpty()){
            System.out.println("no data found");
        }

        Output output = null;
        if (value.equalsIgnoreCase("table")){
                output = new TableOutput();
            }
        else if (value.equalsIgnoreCase("text")) {
                output = new TextOutput();
        } else {
            System.out.println("invalid format");
        }

        assert output != null;
        output.display(data);
    }

}

