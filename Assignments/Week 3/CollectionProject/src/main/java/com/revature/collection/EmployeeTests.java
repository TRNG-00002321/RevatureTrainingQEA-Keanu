package com.revature.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeTests {
    static void main() {
        List<Employee> myL = new ArrayList<Employee>();

        myL.add(new Employee(1,"Keanu",15000.0));
        myL.add(new Employee(2,"Bob",50000.0));
        myL.add(new Employee(3,"Joe",27000.0));
        myL.add(new Employee(4,"John",10000.0));
        myL.add(new Employee(5,"George",40000.0));

        Collections.sort(myL, new IDComparator());
        System.out.println("\n Sort by ID");
        System.out.println(myL);

        Collections.sort(myL, new nameComparator());
        System.out.println("\n Sort by Name");
        System.out.println(myL);

        Collections.sort(myL, new salaryComparator());
        System.out.println("\n Sort by salary");
        System.out.println(myL);
    }
}
