package com.learning;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        DataManager datamanager = new DataManager();
        datamanager.getDataForPerNr();

        System.out.println(" ");
        datamanager.displayData("text");
        System.out.println(" ");
        datamanager.displayData("table");

        System.out.println(" ");
        System.out.println(" Data from Database ");


    }
}
