import pandas as pd

expenses = pd.read_csv('expenses.csv')

def DisplayExpenses():
    global expenses

    print(expenses.to_string())

def AddExpense(expense:dict):
    global expenses
    


