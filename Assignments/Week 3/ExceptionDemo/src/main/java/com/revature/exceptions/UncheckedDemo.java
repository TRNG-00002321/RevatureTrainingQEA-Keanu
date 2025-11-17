package com.revature.exceptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UncheckedDemo {
    public static void main(String[] args){
        try {
            FileInputStream file = new FileInputStream("MyFile.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
