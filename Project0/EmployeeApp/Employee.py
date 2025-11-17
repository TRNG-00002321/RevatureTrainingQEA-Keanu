import pandas as pd
import sqlite3 as sql

class Employee:
    expenses = pd.DataFrame()
    employee_id = 0


    @staticmethod
    def Login():
        global expenses
        global employee_id

        #connect to users database
        conn = sql.connect("users.db")

        #ask for user's username and password
        username = input("Enter your username: ")
        password = input("Enter your password: ")

        #read in employees table
        employees = pd.read_sql_query("SELECT * FROM users", conn)
        conn.close()

        #if username and password are correct
        if employees[username] == username and employees[password] == password:
            print("Login Successful")
            #establish new connection to expenses database
            conn = sql.connect("expenses.db")

            #get expenses of employee
            expenses = pd.read_sql_query("SELECT * FROM expenses WHERE {}", conn)
            #get employee id
            employee_id = employees["id"]

            conn.close()

    @staticmethod
    def AddExpense(self):
        conn = sql.connect("expenses.db")

        #get user input for new expense
        amount = float(input("Enter your expense amount: "))
        description = input("Enter your expense description: ")

        #fill in values for new expense dataframe
        new_expense = pd.DataFrame({"id":[0],
                                    "user_id": [0],
                                    "amount": [amount],
                                    "description": [description],
                                    "date": [0]})

        #append new expense to expenses database
        new_expense.to_sql("expenses", conn, if_exists="append", index=False)
        conn.close()

    def ViewExpenses(self):

        #connect to expenses database
        conn = sql.connect("expenses.db")

        #select expenses with a valid id
        exp = pd.read_sql_query("SELECT * FROM expenses WHERE user_id == employee_id", conn)
        print(exp.to_string())

    def DeleteExpense(self):
        #connect to expenses database
        conn = sql.connect("expenses.db")

        #get expenses with employee id
        exp = pd.read_sql_query("SELECT * FROM expenses WHERE user_id == employee_id", conn)

        #close connection to expenses database
        conn.close()

        #connect to approvals database
        conn = sql.connect("approvals.db")








