package com.learning;

public class main {

    public static void main(String[] args){
        DataManager datamanager = new DataManager();

        datamanager.setData(1,"Alice", "Romo", 25, "alice.rom@gmail,com");
        datamanager.setData(2, "juan", "Müller", 45, "juan.M@gmail,com");
        datamanager.setData(3, "Alan", "Jesuita", 78, "jesu.Ala@gmail,com");

        System.out.println(" ");
        datamanager.displayData("text");
        System.out.println(" ");
        datamanager.displayData("table");

        System.out.println(" ");
        System.out.println(" Data from Database ");
        Database.dbConnection();


    }
}
