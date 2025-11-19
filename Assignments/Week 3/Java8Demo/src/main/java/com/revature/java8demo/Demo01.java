package com.revature.java8demo;

import java.util.Locale;
import java.util.Optional;

public class Demo01 {
    static void main(String[] args) {
        String[] words = new String[10];
        words[5] = "Perry";

        /*String word = words[5].toLowerCase();
        System.out.println(word);*/

        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if(checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
        }
        else{
            System.out.println("Word is null");
        }

        //Write a lambda function that does not take a parameter and does not return a value
        //but simply prints hello

        //Write another lambda function that takes one string parameter and returns hello and
        //the argument in uppercase

        //Write the lambda function with 2 string parameters firstname and lastname.
        //returns hello and the firstname and lastname concatenated

        //Create a class named address having the following fields (street, city, zipcode)
        //create constructors, setters and getters, and toString methods
        //Create another class as person having name, phone, and address
        //Create a main class wherein define 2 person objects one with address and one without address
        //and check the nullability of address

        //Stream notes
        //Display the employee with enhanced for loop
        //Display with for each loop
        //Return all employee names in upperscase
        //From the existing list create a list of employees with salary more than 20,000 using filter method
        //

    }
}
