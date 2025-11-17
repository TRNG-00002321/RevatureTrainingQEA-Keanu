package com.revature.employee;

public class SalaryEmployee extends Employee{

    private final String benefits = "Food Coupon";

    public SalaryEmployee() {
    }

    public SalaryEmployee(String name, double payrate) {
        super(name, payrate);
    }

    public SalaryEmployee(String name, double payrate, double pay) {
        super(name, payrate, pay);
    }

    @Override
    public String toString() {
        return "SalaryEmployee{" +
                "benefits='" + benefits + '\'' +
                "} " + super.toString();
    }

    @Override
    public double calculatePay(int days) {
        double payrate = super.getPayrate();
        payrate *= days;
        super.setPay(payrate);

        return payrate;
    }
}
