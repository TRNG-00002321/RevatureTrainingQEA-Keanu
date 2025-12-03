package com.revature.expense.util;

import com.revature.expense.dao.ExpensesImpl;
import com.revature.expense.service.ExpensesService;
import com.revature.expense.service.ExpensesServiceImpl;
import com.revature.expense.service.UsersService;
import com.revature.expense.service.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final ExpensesService expensesService = new ExpensesServiceImpl();
    private static final UsersService usersService = new UsersServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);

    public static void DisplayMenu(){
        Scanner sc = new Scanner(System.in);

        //user input
        int input = 0;
        //bool for exiting while loop
        boolean exitLoop = false;

        do{
            //print menu to screen
            System.out.println("======Manager App======");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Quit");
            System.out.println("Enter option: ");

            try{
                //get user input
                input = sc.nextInt();
            }catch (InputMismatchException e){
                logger.error("Invalid user input in Login screen:{}", e.getMessage());
                System.out.println("Invalid input- Exiting Application...");
                return;
            }

            //routes user input to correct service function
            switch (input){
                case 1:
                    exitLoop = usersService.Login();
                    break;
                case 2:
                    usersService.CreateAccount();
                    break;
                case 3:
                    System.out.println("Quitting Application...");
                    return;
                default:
                    System.out.println("Invalid input...");
                    break;
            }

        }while(!exitLoop);

        do{
            //print menu to screen
            System.out.println("======Manager App Menu======");
            System.out.println("1. View Pending Expenses");
            System.out.println("2. Generate Expense Report by Amount");
            System.out.println("3. Approve Expense");
            System.out.println("4. Deny Expense");
            System.out.println("5. Quit");
            System.out.println("Enter option: ");

            try{
                //get user input
                input = sc.nextInt();
            }catch (InputMismatchException e){
                logger.error("Invalid user input in Main Menu:{}", e.getMessage());
                System.out.println("Invalid input- Exiting Application...");
                return;
            }

            //routes user input to correct service function
            switch (input){
                case 1:
                    expensesService.ViewExpenses();
                    break;
                case 2:
                    expensesService.ViewExpenseReport();
                    break;
                case 3:
                    expensesService.ApproveExpense();
                    break;
                case 4:
                    expensesService.DenyExpense();
                    break;
                case 5:
                    System.out.println("Quitting Application...");
                    return;
                default:
                    System.out.println("Invalid input...");
                    break;
            }
        }while(true);
    }
}
