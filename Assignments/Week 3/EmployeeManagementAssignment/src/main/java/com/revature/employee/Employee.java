package com.revature.employee;
//Assignment: Create a mini project to simulate employee management
//There are 2 categories of employees - salaried and contractual employees
//Salary is calculated based on the number of days present
//For contractual employee it is based on number of hours worked
//Salaried employees are provided with some benefits like food coupons
//Declare variables and calculate salary
//Please use runtime values with scanner

public abstract class Employee {
    private String name;
    private double payrate;
    private double pay = 0;

    public Employee() {

    }

    public Employee(String name, double payrate) {
        this.name = name;
        this.payrate = payrate;
    }

    public Employee(String name, double payrate, double pay) {
        this.name = name;
        this.payrate = payrate;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", payrate=" + payrate +
                ", pay=" + pay +
                '}';
    }

    public abstract double calculatePay(int time);

    public double getPayrate() {
        return payrate;
    }

    public void setPayrate(double payrate) {
        this.payrate = payrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
