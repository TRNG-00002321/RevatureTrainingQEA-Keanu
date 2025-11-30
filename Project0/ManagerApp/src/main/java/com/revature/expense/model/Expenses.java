package com.revature.expense.model;

import java.time.LocalDateTime;

public class Expenses {
    private int id;                 //Primary Key
    private int user_id;            //Foreign Key to users
    private double amount;          //Expense amount(must be at least $500
    private String description;     //Reason for expense request
    private LocalDateTime date;     //Date of expense

    public Expenses() {
    }

    public Expenses(int id, int user_id, double amount, String description, LocalDateTime date) {
        this.id = id;
        this.user_id = user_id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Expenses(int user_id, double amount, String description, LocalDateTime date) {
        this.user_id = user_id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
