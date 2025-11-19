package com.revature.java8assignments;

public class LambdaAssignment {
    static void main() {

        //Printer prints = ()->{return "Hello";};

        //Printer prints = (s)->{return "Hello " + s.toUpperCase();};

        Printer prints = (s1,s2)->{return "Hello " + s1.concat(s2);};




        System.out.println(prints.prints("Keanu", "Cendejas"));
    }
}
