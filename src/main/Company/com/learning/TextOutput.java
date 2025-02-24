package com.learning;

import java.util.List;

class TextOutput extends Output {

    private String toString(DataObject entry) {
        return entry.getFirstName() + " " + entry.getLastName() + " is " + entry.getAge() + " years old and email is " + entry.getEmail();
    }
    public void display(List<DataObject> data){
        System.out.println("data as a text: ");
        for (DataObject entry : data){
            System.out.println(toString(entry));
        }
    }
}
