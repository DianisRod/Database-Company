package com.learning;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

public class main {

    public static void main(String[] args){
        DataManager datamanager = new DataManager();


        datamanager.setData(1,"Alice", "Romo", 25, "alice.rom@gmail,com");
        datamanager.setData(2, "juan", "Müller", 45, "juan.M@gmail,com");
        datamanager.setData(3, "Alan", "Jesuita", 78, "jesu.Ala@gmail,com");

        datamanager.displayData("text");
        System.out.println(" ");
        datamanager.displayData("table");

        Database.dbConnection();

    }
}
