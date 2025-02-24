package com.learning;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    //properties instance variables
    private List<DataObject> data;

    public DataManager() {
        this.data = new ArrayList<>(); // Initialisierung der Liste
    }

    public void setData(int perNr, String firstName, String lastName, int age, String email) {
       DataObject newEntry = new DataObject(perNr, firstName, lastName, age, email);
       data.add(newEntry);
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

