package com.learning;

import java.util.List;

public class TableOutput extends Output {

    public void display(List<DataObject> data){

        System.out.println("table output: ");
        System.out.printf("%-15s %-15s %-5s %-25s%n", "First Name", "Last Name", "Age", "Email");
        System.out.println("------------------------------------------------------------");
        for (DataObject entry : data){
            System.out.printf("%-15s %-15s %-5s %-25s%n", entry.getFirstName(), entry.getLastName(), entry.getAge(), entry.getEmail());
        }
    }
}
