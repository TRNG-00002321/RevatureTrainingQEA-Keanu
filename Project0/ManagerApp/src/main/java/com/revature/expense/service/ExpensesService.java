package com.revature.expense.service;

public interface ExpensesService {
    void ViewExpenses();
    void DenyExpense();
    void ApproveExpense();
    @SuppressWarnings("removal")
    void ViewExpenseReport();
}
