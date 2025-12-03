import mysql.connector
import database
from datetime import datetime
import pandas as pd
import logging
logger = logging.getLogger(__name__)

#-------------------------
# Expense Functions
#-------------------------

def AddExpense(user_id):
    print("\n=== Add a New Expense ===")
    try:
        amount = float(input("Amount: "))
    except ValueError:
        logger.error("Invalid expense amount.")
        print("Invalid amount.")
        return

    #Get expense description
    description = input("Description: ")

    #Get today's date
    date = datetime.now()

    #connect to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

    #create new expense and insert into table
    try:
        c.execute(
            "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?)",
            (user_id, amount, description, date)
        )
        logger.info("Expense added successfully!")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        print("Amount must be > $500.")
        return

    #gets newly added expense id
    expense_id = c.lastrowid

    #create pending approval in approvals table
    try:
        c.execute(
            "INSERT INTO approvals (expense_id, status, reviewer, comment, review_date) VALUES (?, ?, ?, ?, ?)",
            (expense_id, "pending", None, None, None)
        )
        logger.info("Approval added successfully!")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return


    conn.commit()
    print("Expense added successfully.")

###################################################################################################

def ViewExpenses(user_id):
    print("\n=== Your Expenses ===")

    #connect to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

    try:
        #select rows from expenses joined with approval status
        c.execute("""
                SELECT expenses.id, amount, description, expenses.date, approvals.status
                FROM expenses
                    JOIN approvals
                ON expenses.id = approvals.expense_id
                WHERE user_id=?
                """, (user_id,))
        logger.info("Database query successful")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return

    #Get all rows
    rows = c.fetchall()

    #If no expenses found from user
    if not rows:
        print("No expenses found.")
        return
    else:
        #print out all columns
        pd.set_option('display.max_columns', None)

        #print out all rows
        pd.set_option('display.max_rows', None)

        #display all rows as a dataframe
        column_names = ["ID", "Amount", "Description", "Date", "Status"]
        df = pd.DataFrame(rows, columns=column_names).set_index('ID')
        df.sort_values(by=['Date'], inplace=True)

        print(df)

###################################################################################################

def EditExpense(user_id):

    #Get user input
    print("\n=== Edit Pending Expense ===")
    expense_id = input("Expense ID to edit: ")

    #connect to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

    #check ownership & pending
    try:
        c.execute("""
            SELECT expenses.id
            FROM expenses
            JOIN approvals ON expenses.id = approvals.expense_id
            WHERE expenses.id=? AND user_id=? AND approvals.status='pending'
        """, (expense_id, user_id))

        logger.info("Database query successful")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return

    #checks if any pending expenses were found
    if not c.fetchone():
        print("No editable pending expense found with that ID.")
        return

    #tries to get new amount from user input
    try:
        new_amount = float(input("New Amount: "))
    except ValueError:
        print("Invalid amount.")
        return

    #gets new description from user input
    new_description = input("New Description: ")

    try:
        #updates expenses with new amount and description
        c.execute("""
            UPDATE expenses
            SET amount=?, description=?
            WHERE id=?
        """, (new_amount, new_description, expense_id))
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return

    conn.commit()
    print("Expense updated successfully!")

###################################################################################################

def DeleteExpense(user_id):

    #Get expense id for deletion
    print("\n=== Delete Pending Expense ===")
    expense_id = input("Expense ID to delete: ")

    #connect to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

    try:
        #check ownership & pending
        c.execute("""
            SELECT expenses.id
            FROM expenses
                JOIN approvals ON expenses.id = approvals.expense_id
            WHERE expenses.id=? AND user_id=? AND approvals.status='pending'
        """, (expense_id, user_id))
        logger.info("Database query successful")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return

    #checks if any pending expenses were found
    if not c.fetchone():
        print("No pending expenses found with that ID.")
        return

    try:
        #delete expenses that have expense id from approvals and expenses tables
        c.execute("DELETE FROM expenses WHERE id=?", expense_id)
        logger.info("Database query successful")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return

    conn.commit()

###################################################################################################

def ViewExpenseHistory(user_id):
    print("\n=== View Expense History ===")

    #connects to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

    try:
        #Selects rows that from expenses that are not pending
        c.execute("""
            SELECT expenses.id, amount, description, expenses.date, approvals.status, approvals.comment
            FROM expenses
                JOIN approvals ON expenses.id = approvals.expense_id
                WHERE user_id=? AND approvals.status != 'pending'
                ORDER BY expenses.date
        """, (user_id,))
        logger.info("Database query successful")
    except mysql.connector.errors.Error as e:
        logger.error("Database query error", e.msg)
        return

    #gets rows list
    rows = c.fetchall()

    #if no rows found then return
    if not rows:
        print("No expense history found.")
        return

    #print out all columns
    pd.set_option('display.max_columns', None)
    #print out all rows
    pd.set_option('display.max_rows', None)

    #display rows as dataframe
    column_names = ["ID", "Amount", "Description", "Date", "Status", "Comment"]
    df = pd.DataFrame(rows, columns=column_names).set_index('ID')
    df.sort_values(by=['Date'], inplace=True)

    print(df)


