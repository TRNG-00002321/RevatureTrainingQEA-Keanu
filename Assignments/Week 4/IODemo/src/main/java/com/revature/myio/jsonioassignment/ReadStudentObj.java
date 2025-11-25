package com.revature.myio.jsonioassignment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadStudentObj {
    static void main() {

        ObjectMapper objectMapper = new ObjectMapper();

        try(FileInputStream fileInputStream = new FileInputStream("student.json")){
            Student student = objectMapper.readValue(fileInputStream, Student.class);

            System.out.println(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
