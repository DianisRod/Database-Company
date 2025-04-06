package com.learning;

import java.util.List;

public class TableOutput extends Output {

    public void display(List<DataObject> data){

        System.out.println("table output: ");
        System.out.printf("%-15s %-15s %-25s %-25s%n", "PerNr","First Name", "Last Name", "Age", "Email");
        System.out.println("------------------------------------------------------------");
        for (DataObject entry : data){
            System.out.printf("%-15s %-15s %-25s %-25s%n",entry.getPerNr(), entry.getFirstName(), entry.getLastName(), entry.getAge(), entry.getEmail());
        }
    }
}
