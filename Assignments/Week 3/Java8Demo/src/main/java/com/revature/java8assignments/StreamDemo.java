package com.revature.java8assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    static void main() {
        Employee e1 = new Employee("Keanu", 10000.0);
        Employee e2 = new Employee("Bob", 50000.0);
        Employee e3 = new Employee("Joe", 30000.0);

        List<Employee> myL = new ArrayList<Employee>();

        myL.add(e1);
        myL.add(e2);
        myL.add(e3);

        for(Employee employee : myL){
            System.out.println(employee);
        }

        myL.stream().forEach(employee -> employee.setName(employee.name.toUpperCase()));


        myL.stream().forEach(employee -> System.out.println(employee));

        List<Employee> myL2 = myL.stream().
                filter(employee -> employee.salary < 20000.0)
                .toList();

        myL2.stream().forEach(employee -> System.out.println(employee));




    }
}
