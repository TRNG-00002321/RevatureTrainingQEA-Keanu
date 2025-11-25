package com.revature.myio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileStreamsDemo03 {
    public void main() throws Exception{

        try (BufferedReader inputStream = new BufferedReader(new FileReader("example.txt"));
             BufferedWriter outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"))) {

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.write(l);
            }
        }
    }
}
