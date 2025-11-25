package com.revature.myio.serialize;

import java.io.*;

public class ReadEmpObj {

    static void main() throws IOException {

        try(FileInputStream fileInputStream = new FileInputStream("employee.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            Employee emp = (Employee) objectInputStream.readObject();
            System.out.println(emp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
