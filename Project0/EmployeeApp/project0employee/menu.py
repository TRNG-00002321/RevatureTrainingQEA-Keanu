from project0employee.create_employee import create_employee
from project0employee.expensefunctions import AddExpense, EditExpense, DeleteExpense, ViewExpenses, ViewExpenseHistory


#Main menu for the python employee program
def menu(user_id):
    while True:

        #Print main menu to screen
        print("\n====== Employee Menu ======")
        print("1. Add Expense")
        print("2. Edit Expense")
        print("3. Delete Expense")
        print("4. View Expenses")
        print("5. View Denied/Approved Expense History")
        print("6. Exit")

        #get user input
        option = int(input("Select an option: "))

        #match statement for options
        match option:
            case 1:
                AddExpense(user_id)
            case 2:
                EditExpense(user_id)
            case 3:
                DeleteExpense(user_id)
            case 4:
                ViewExpenses(user_id)
            case 5:
                ViewExpenseHistory(user_id)
            case 6:
                print("Logging out...")
                break
            case _:
                print("Invalid option!")

    return False