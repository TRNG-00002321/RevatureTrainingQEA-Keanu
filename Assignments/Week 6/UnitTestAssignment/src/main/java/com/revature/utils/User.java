package com.revature.utils;

public class User {
    private String FirstName;
    private String LastName;
    private int Age;
    private String Email;

    public User(String firstName, String lastName, int age, String email) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
