package com.revature.expense.service;

import com.revature.expense.dao.ExpensesImpl;
import com.revature.expense.model.Expenses;

import java.util.List;
import java.util.Scanner;

public class ExpensesServiceImpl implements ExpensesService{
    private final ExpensesImpl expensesDAO = new ExpensesImpl();
    @Override
    public void ViewExpenses() {

        //Get list of pending expenses
        List<Expenses> expensesList = expensesDAO.getPendingExpenses();

        System.out.println("======Pending Expenses======");

        //print all pending expenses to screen
        for(Expenses expense : expensesList){
            System.out.println(expense);
        }
    }

    @Override
    public void DenyExpense() {
        Scanner sc = new Scanner(System.in);

        //Get user input for expense id
        System.out.println("======Deny Expenses======");
        System.out.println("Enter expense ID: ");
        int expense_id = sc.nextInt();
        sc.nextLine();

        //get current manager ID
        int manager_id;
        if (UsersServiceImpl.getManager() != null) {
            manager_id = UsersServiceImpl.getManager().getId();
        }
        else{
            System.out.println("Manager ID not found");
            return;
        }

        //get user input for comment
        System.out.println("Enter comment: ");
        String comment = sc.nextLine();

        //deny expense
        expensesDAO.denyExpense(expense_id, manager_id, comment);
        System.out.println("Expense Denied");

    }

    @Override
    public void ApproveExpense() {
        Scanner sc = new Scanner(System.in);

        //get user input for expense id
        System.out.println("======Approve Expenses======");
        System.out.println("Enter expense ID: ");
        int expense_id = sc.nextInt();
        sc.nextLine();

        //get current manager id
        int manager_id;
        if (UsersServiceImpl.getManager() != null) {
            manager_id = UsersServiceImpl.getManager().getId();
        }
        else{
            System.out.println("Manager ID not found");
            return;
        }

        //get user input for comment
        System.out.println("Enter comment: ");
        String comment = sc.nextLine();

        //approve expense
        expensesDAO.approveExpense(expense_id, manager_id, comment);
        System.out.println("Expense Approved");
    }
}
