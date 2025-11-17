package com.revature.person;

public class PersonManager {

    public static void main(String[] args){
        Person person1 = new Person("Bob", 20);
        Person person2 = new Person("Bob", 20);

        System.out.println("Person 1 is: " + person1);
        System.out.println("Person 2 is: " + person2);

        if(person1.equals(person2)){
            System.out.println("Person 1 is equal to Person 2");
        }
        else{
            System.out.println("Person 1 is NOT equal to Person 2");
        }
    }
}

