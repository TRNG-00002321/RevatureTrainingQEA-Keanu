package com.revature.employee;

public class ContractEmployee extends Employee{
    public ContractEmployee() {
    }

    public ContractEmployee(String name, double payrate) {
        super(name, payrate);
    }

    public ContractEmployee(String name, double payrate, double pay) {
        super(name, payrate, pay);
    }

    @Override
    public String toString() {
        return "ContractEmployee{} " + super.toString();
    }

    @Override
    public double calculatePay(int hours) {
        double payrate = super.getPayrate();
        payrate *= hours;
        super.setPay(payrate);

        return payrate;
    }
}
