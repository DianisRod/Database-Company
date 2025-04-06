package com.learning;

import java.sql.SQLException;

public class main {
    static DataManager datamanager = new DataManager();


    public static void main(String[] args) throws SQLException {
        showDatainDB();
        //datamanager.getDatafromFortyHoursWorkers();
        //datamanager.getEmployesThatStartedAfter2022();
        //createNewEmploye();
        // datamanager.DeleteOldestEmployer();

    }
    public static void createNewEmploye() throws SQLException {
        datamanager.createData("Jhon", "Lotte", 44, "Jhon.Lot@hotmail.com");

    }

    public static void showDatainDB() throws SQLException {
        datamanager.getDataForPerNr();
        System.out.println(" Data from Database ");
        System.out.println(" ");
        datamanager.displayData("text");
        System.out.println(" ");
        datamanager.displayData("table");
    }

}

