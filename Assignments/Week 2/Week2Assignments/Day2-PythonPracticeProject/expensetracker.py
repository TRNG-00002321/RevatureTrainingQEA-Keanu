import pandas as pd
from datetime import date
import os

from unicodedata import category

csv_file = 'expenses.csv'

headers = ['ID', 'Date', 'Amount', 'Category']

#Loads in csv file
if os.path.exists(csv_file):
    expenses = pd.read_csv(csv_file)
else:
    expenses = pd.DataFrame(columns=headers)

#Function for recieving user input into a dataframe
def get_input():
    global expenses

    # creates a set of existing ID values
    existing_IDs = set(expenses["ID"]) if not expenses.empty else set()

    while True:
        try:
            # Makes sure ID is unique
            id_val = int(input("Enter ID (integer): "))
            if id_val in existing_IDs:
                print("That ID already exists. Please enter a unique value.")
            else:
                break
        except ValueError:
            print("Invalid ID type.")

    #Gets date input in ISO format
    while True:
        date_str = input("Enter date (YYYY-MM-DD): ").strip()

        try:
            # Validate date format
            pd.to_datetime(date_str, format="%Y-%m-%d")
            break
        except ValueError:
            print("Invalid date format.")

    #Gets expense amount as float
    while True:
        try:
            amount = float(input("Enter amount (float): "))
            if amount < 0:
                print("Amount cannot be negative. Enter a valid amount.")
            else:
                break
        except ValueError:
            print("Invalid amount.")

    #Gets expense category as a string
    category = input("Enter category (string): ").strip()

    #Returns dataframe containing new expense data
    return {"ID": [id_val], "Date": [date_str], "Amount": [amount], "Category": [category]}

def AddExpense():
    global expenses

    #gets input for new expense
    expense = get_input()

    #creates new dataframe with new expense data
    new_expense = pd.DataFrame(expense, columns=headers)

    #writes new expense to csv file
    new_expense.to_csv('expenses.csv', mode='a', header=False, index=False)

def ViewExpenses():
    print(expenses)

def DeleteExpense():
    global expenses

    ID = int(input("Enter ID to delete expense: "))

    if ID not in expenses["ID"].values:
        print("No expense with that ID.")
    else:
        expenses = expenses[expenses["ID"] != ID]

    expenses.to_csv('expenses.csv', index=False)

def UpdateExpense():
    global expenses

    ID = int(input("Enter ID to update expense: "))

    #Check if ID exists in file
    if ID in expenses["ID"].values:
        #get index of expense with ID
        index = expenses.index[expenses["ID"] == ID][0]

        print("Enter new expense data:")
        # Gets date input in ISO format
        while True:
            date_str = input("Enter date (YYYY-MM-DD): ").strip()

            try:
                # Validate date format
                pd.to_datetime(date_str, format="%Y-%m-%d")
                break
            except ValueError:
                print("Invalid date format.")

        # Gets expense amount as float
        while True:
            try:
                amount = float(input("Enter amount (float): "))
                if amount < 0:
                    print("Amount cannot be negative. Enter a valid amount.")
                else:
                    break
            except ValueError:
                print("Invalid amount.")

        # Gets expense category as a string
        category = input("Enter category (string): ").strip()

        #Updates expense values
        expenses.at[index, "Date"] = date_str
        expenses.at[index, "Amount"] = amount
        expenses.at[index, "Category"] = category

        #Updates csv file
        expenses.to_csv('expenses.csv', index=False)

    else:
        print("No expense with that ID.")

def GetTotalExpenses():
    global expenses

    #gets sum of all expenses
    total = expenses["Amount"].values.sum()

    #displays total in dollar format
    print("$%.2f" % total)

def GetTotalExpensesByCategory():
    global expenses

    #asks for which category to show total expenses for
    category_ = input("Show expenses by which category? ")

    #gets sums of all categories
    totals = expenses.groupby("Category")["Amount"].sum()

    #prints total based on input category
    print("$%.2f" % totals[category_])

def GetTotalExpensesByDate():
    global expenses

    #converts date categories to datetime format
    expenses["Date"] = pd.to_datetime(expenses["Date"], errors="coerce")
    expenses = expenses.dropna(subset=["Date"])

    #Gets user input for date range
    try:
        start = pd.to_datetime(input("Enter start date (YYYY-MM-DD): ").strip())
        end = pd.to_datetime(input("Enter end date (YYYY-MM-DD): ").strip())
    except ValueError:
        print("Invalid date format.")
        exit()

    #filters out all expenses by the date range
    mask = mask = (expenses["Date"] >= start) & (expenses["Date"] <= end)
    filtered_expenses = expenses.loc[mask]

    # check if dates were found
    if filtered_expenses.empty:
        print("No expenses found in the given date range.")
    else:
        #gets sum of expenses based on filtered dates and prints
        total = filtered_expenses["Amount"].sum()
        print(f"Total expenses from {start} to {end}: ${total:.2f}")






