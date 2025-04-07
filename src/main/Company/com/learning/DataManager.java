package com.learning;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    //singleton Instance
    private Database database;
    private static Connection connection;
    private static List<DataObject> data;
    private int lastPerNr = 0;

    public DataManager() {
        try {
            database = Database.getInstance();
            connection = database.getConnection();
            data = new ArrayList<>();
        } catch (SQLException e) {
            System.err.println("❌ Failed to initialize Database: " + e.getMessage());
        }
    }

    public void clearList(){
        data.clear();

    }

    public void setData(int PerNr, String firstName, String lastName, int age, String email) throws SQLException {
        String insertSql = "INSERT INTO company(PerNr, firstName, lastName, age, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setInt(1, PerNr);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            //ResultSet resultSet = preparedStatement.executeQuery();
        }

        DataObject newEntry = new DataObject(PerNr, firstName, lastName, age, email);
       data.add(newEntry);
    }

    public void createData(String firstName, String lastName, int age, String email) throws SQLException {
        String insertSql = "INSERT INTO company (PerNr, firstName, lastName, age, email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        int personalNumber = gen_pernr();
        try {
            preparedStatement.setInt(1, personalNumber);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();
        } finally {
            preparedStatement.close();
        }

        DataObject newEntry = new DataObject(personalNumber, firstName, lastName, age, email);
        data.add(newEntry);
    }

    public void getDataForPerNr() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT PerNr, firstName, lastName, age, email FROM company ";
        ResultSet rs = statement.executeQuery(sql);
        for (int i = 0; i < rs.getFetchSize(); i++) {
            System.out.println();
        }
        while (rs.next()){
            setData(rs.getInt("PerNr"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"), rs.getString("email"));
        }
    }

    //create new function gen_pernr
    public int gen_pernr() throws SQLException {
        //Database connection
        if (lastPerNr == 0) {
            String checkPernrsql = "SELECT MAX(PerNr) from Company";
            //Database read
            try (PreparedStatement preparedStatement = connection.prepareStatement(checkPernrsql);
                 ResultSet execute = preparedStatement.executeQuery()) {

                if (execute.next()) {
                    lastPerNr = execute.getInt(1);
                } else if (execute.wasNull()) {
                        return 10001;
                }
            }
        }
        return ++lastPerNr;
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

    public void getDatafromFortyHoursWorkers() throws SQLException {
        clearList();
        Statement statement = connection.createStatement();
        System.out.println("we have workers who worked 40 hours in the week and get:");
        System.out.printf("%-15s %-15s%n", "Bonus","AnnualSalary");
        String sql = "SELECT B.Bonus, B.annualSalary from salary as B JOIN WorkingTime as W on W.PerNr = B.PerNr where WorkingTime = 40;";
        ResultSet wt = statement.executeQuery(sql);
        while (wt.next()) {
            System.out.printf("%-15s %-15s %n",wt.getInt(1), wt.getInt(2));
        }
    }

    //TODO: Please write a SQL statement, which increases the bonus by 500€ in the salary table for all
    //employees, who are working 40 hours.
    //


    public void getEmployesThatStartedAfter2022() throws SQLException {
        clearList();
        Statement statement = connection.createStatement();
        System.out.println("employees who have started 2020 or later to work for the company:");
        System.out.printf("%-15s %-15s %-25s %-25s%n", "name", "lastname", "email", "BeginDate");
        String sql = "SELECT C.firstName, C.Lastname, C.email, W.BeginDate from company AS C JOIN WorkingTime W on W.PerNr = C.PerNr WHERE Year(BeginDate) >= 2022 ;";
        ResultSet cw = statement.executeQuery(sql);
        while (cw.next()) {
            System.out.printf("%-15s %-15s %-25s %-25s%n", cw.getString(1), cw.getString(2), cw.getString(3), cw.getString(4));
        }
    }

    public void DeleteOldestEmployer() throws SQLException {
        try {
            String sql = "DELETE FROM company ORDER BY age DESC Limit 1";
            PreparedStatement delete = connection.prepareStatement(sql);
            delete.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public int CountElements(String tableName) throws SQLException {
        clearList();
        Statement countStatement = connection.createStatement();
        String sql = "SELECT (COUNT(*)) from " + tableName;
        ResultSet counter = countStatement.executeQuery(sql);
        int counts = 0;
        while (counter.next()) {
            counts = counter.getInt(1);
            System.out.println(counts);
        }
        return counts;
    }
}

