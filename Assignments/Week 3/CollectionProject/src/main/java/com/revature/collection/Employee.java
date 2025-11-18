package com.revature.collection;

import java.util.Comparator;

//Create 5 employees and add them to a list to display the list
//display the list sorted by id
//display the list sorted by name
//display the list sorted by salary
//override comparable and comparator
//compare method defines natural sorting order
//comparator method defines other sorting orders
//Collections.sort has an overload with input comparators
public class Employee implements Comparable<Employee>{
    private int ID;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int ID, String name, double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getID(), o.getID());
    }
}

class IDComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getID(), o2.getID());
    }
}

class nameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class salaryComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
