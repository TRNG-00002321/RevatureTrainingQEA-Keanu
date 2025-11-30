package com.revature.expense.dao;

import com.revature.expense.model.Expenses;

import java.sql.SQLException;
import java.util.List;

public interface ExpensesDAO {
    public List<Expenses> getPendingExpenses();
    public void denyExpense(int id, int manager_id, String comment);
    public void approveExpense(int id, int manager_id, String comment);
}
