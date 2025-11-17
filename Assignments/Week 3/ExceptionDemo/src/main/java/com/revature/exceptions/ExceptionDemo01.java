package com.revature.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo01 {

    public static void main(String[] args){
        int [] myArray = new int[5];

        try {
            myArray[5] = 10;
            FileInputStream file = new FileInputStream("MyFile.txt");
            System.out.println("Array Initialized");
        }
        catch(FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Finally Block");
        }

        System.out.println("Ending Execution........");
    }
}
