import sqlite3
import database
import datetime

#-------------------------
# Expense Functions
#-------------------------

def AddExpense(user_id):
    print("\n=== Add a New Expense ===")
    try:
        amount = float(input("Amount: "))
    except ValueError:
        print("Invalid amount.")
        return

    #Get expense description
    description = input("Description: ")

    #Get today's date
    date = datetime.date.today().isoformat()

    #connect to database
    conn = sqlite3.connect(database.DB_PATH)
    c = conn.cursor()

    #create new expense and insert into table
    c.execute(
        "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?)",
        (user_id, amount, description, date)
    )

    #gets newly added expense id
    expense_id = c.lastrowid

    #create pending approval in approvals table
    c.execute(
        "INSERT INTO approvals (expense_id, status, reviewer, comment, review_date) VALUES (?, ?, ?, ?, ?)",
        (expense_id, "pending", None, None, None)
    )

    conn.commit()
    conn.close()
    print("Expense added successfully.")

###################################################################################################

def ViewExpenses(user_id):
    print("\n=== Your Expenses ===")

    #connect to database
    conn = sqlite3.connect(database.DB_PATH)
    c = conn.cursor()

    #select rows from expenses joined with approval status
    c.execute("""
              SELECT expenses.id, amount, description, expenses.date, approvals.status
              FROM expenses
                  JOIN approvals
              ON expenses.id = approvals.expense_id
              WHERE user_id=?
              """, (user_id,))

    #Get all rows
    rows = c.fetchall()
    conn.close()

    #If no expenses found from user
    if not rows:
        print("No expenses found.")
        return
    else:
        #Print out all rows
        for row in rows:
            print(f"\nID: {row[0]}\nAmount: {row[1]}\nDescription: {row[2]}\n"
                  f"Date: {row[3]}\nStatus: {row[4]}")


def EditExpense(user_id):

    #Get user input
    print("\n=== Edit Pending Expense ===")
    expense_id = input("Expense ID to edit: ")

    #connect to database
    conn = sqlite3.connect(database.DB_PATH)
    c = conn.cursor()

    # Check ownership & pending
    c.execute("""
        SELECT expenses.id
        FROM expenses
        JOIN approvals ON expenses.id = approvals.expense_id
        WHERE expenses.id=? AND user_id=? AND approvals.status='pending'
    """, (expense_id, user_id))

    #checks if any pending expenses were found
    if not c.fetchone():
        print("No editable pending expense found with that ID.")
        conn.close()
        return

    #tries to get new amount from user input
    try:
        new_amount = float(input("New Amount: "))
    except ValueError:
        print("Invalid amount.")
        conn.close()
        return

    #gets new description from user input
    new_description = input("New Description: ")

    #updates expenses with new amount and description
    c.execute("""
        UPDATE expenses
        SET amount=?, description=?
        WHERE id=?
    """, (new_amount, new_description, expense_id))

    conn.commit()
    conn.close()
    print("Expense updated successfully!")

def DeleteExpense(user_id):

    #Get expense id for deletion
    print("\n=== Delete Pending Expense ===")
    expense_id = input("Expense ID to delete: ")

    #connect to database
    conn = sqlite3.connect(database.DB_PATH)
    c = conn.cursor()

    # Check ownership & pending
    c.execute("""
        SELECT expenses.id
        FROM expenses
        JOIN approvals ON expenses.id = approvals.expense_id
        WHERE expenses.id=? AND user_id=? AND approvals.status='pending'
    """, (expense_id, user_id))

    #checks if any pending expenses were found
    if not c.fetchone():
        print("No pending expenses found with that ID.")
        conn.close()
        return

    #delete expenses that have expense id
    c.execute("""
        DELETE FROM expenses WHERE expenses.id=?
    """, expense_id)

    #insert logging here
    conn.commit()
    conn.close()
