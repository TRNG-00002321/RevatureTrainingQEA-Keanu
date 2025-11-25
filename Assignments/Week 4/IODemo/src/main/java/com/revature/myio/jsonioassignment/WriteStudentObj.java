package com.revature.myio.jsonioassignment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteStudentObj {
    static void main() {
        Student student = new Student(101,"Keanu","Prosper");

        ObjectMapper objectMapper = new ObjectMapper();

        try(FileOutputStream file = new FileOutputStream("student.json")){
            objectMapper.writeValue(file, student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
