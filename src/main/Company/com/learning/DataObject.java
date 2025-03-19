package com.learning;

import java.sql.Connection;

public class DataObject {

    Connection conn = Database.getConnection();

    private int PerNr;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    private int salary;
    private int Bonus;
    private String beginDate;
    private String endDate;

    public DataObject(int PerNr,String firstName, String lastName, int age, String email){
        this.PerNr = PerNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPerNr() {
        return PerNr;
    }

    public void setPerNr(int perNr){
        this.PerNr = perNr;
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
