package com.learning;

import java.sql.Connection;

public class DataObject {

    Connection conn = Database.dbConnection();

    private int perNr;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public DataObject(int perNr,String firstName, String lastName, int age, String email){
        this.perNr = perNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getPerNr() {
        return perNr;
    }

    public void setPerNr(int perNr){
        this.perNr = perNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
