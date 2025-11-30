package com.revature.expense.service;

import com.revature.expense.dao.ExpensesDAO;
import com.revature.expense.dao.ExpensesImpl;
import com.revature.expense.model.Expenses;

import java.util.List;
import java.util.Scanner;

public class ExpensesServiceImpl implements ExpensesService{
    private final ExpensesImpl expensesDAO = new ExpensesImpl();
    @Override
    public void ViewExpenses() {
        List<Expenses> expensesList = expensesDAO.getPendingExpenses();

        System.out.println("======Pending Expenses======");

        for(Expenses expense : expensesList){
            System.out.println(expense);
        }
    }

    @Override
    public void DenyExpense() {
        Scanner sc = new Scanner(System.in);

        System.out.println("======Deny Expenses======");
        System.out.println("Enter expense ID: ");
        int expense_id = sc.nextInt();
        sc.nextLine();

        int manager_id;
        if (UsersServiceImpl.getManager() != null) {
            manager_id = UsersServiceImpl.getManager().getId();
        }
        else{
            System.out.println("Manager ID not found");
            return;
        }

        System.out.println("Enter comment: ");
        String comment = sc.nextLine();

        expensesDAO.denyExpense(expense_id, manager_id, comment);
        System.out.println("Expense Denied");

    }

    @Override
    public void ApproveExpense() {
        Scanner sc = new Scanner(System.in);

        System.out.println("======Approve Expenses======");
        System.out.println("Enter expense ID: ");
        int expense_id = sc.nextInt();
        sc.nextLine();

        int manager_id;
        if (UsersServiceImpl.getManager() != null) {
            manager_id = UsersServiceImpl.getManager().getId();
        }
        else{
            System.out.println("Manager ID not found");
            return;
        }

        System.out.println("Enter comment: ");
        String comment = sc.nextLine();

        expensesDAO.approveExpense(expense_id, manager_id, comment);
        System.out.println("Expense Approved");
    }
}
