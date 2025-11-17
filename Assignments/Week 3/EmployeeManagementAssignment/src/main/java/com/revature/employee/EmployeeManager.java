package com.revature.employee;

import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        SalaryEmployee salaryEmployee = null;
        ContractEmployee contractEmployee = null;

        int choice;

        do{
            //Menu interface
            System.out.println("======Employee Management System======");
            System.out.println("1: Enter Employee Info");
            System.out.println("2: Calculate Employee Pay");
            System.out.println("3: Display Employee Information");
            System.out.println("4: Quit");

            choice = sc.nextInt(); //get user input
            sc.nextLine(); //clears newline

            switch (choice)
            {
                case 1:
                    System.out.println("Input employee type. C = Contracted S = Salaried");
                    String type = sc.nextLine();

                    //creates contracted employee
                    if(type.equalsIgnoreCase("C"))
                    {
                        System.out.println("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.println("Enter Pay Rate");
                        double payRate = sc.nextDouble();

                        contractEmployee = new ContractEmployee(name, payRate);

                        System.out.println("=Employee created=");
                    }
                    //creates salaried employee
                    else if(type.equalsIgnoreCase("S"))
                    {
                        System.out.println("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.println("Enter Pay Rate");
                        double payRate = sc.nextDouble();

                        salaryEmployee = new SalaryEmployee(name, payRate);

                        System.out.println("=Employee created=");
                    }
                    else{
                        System.out.println("Incorrect input");
                    }

                    break;

                case 2:
                    //calculates contract pay
                    if(contractEmployee != null){
                        System.out.println("Enter hours worked for contract employee: ");
                        int hours = sc.nextInt();

                        contractEmployee.calculatePay(hours);
                        System.out.println("=Pay Calculated=");
                    }

                    //calculates salaried pay
                    if(salaryEmployee != null){
                        System.out.println("Enter days worked for salaried employee: ");
                        int days = sc.nextInt();

                        salaryEmployee.calculatePay(days);
                        System.out.println("=Pay Calculated=");
                    }

                    break;

                case 3:

                    //displays employee information
                    if(contractEmployee != null){
                        System.out.println(contractEmployee);
                    }

                    if(salaryEmployee != null){
                        System.out.println(salaryEmployee);
                    }

                    break;
            }
        }
        while(choice != 4);

        sc.close();
    }
}
