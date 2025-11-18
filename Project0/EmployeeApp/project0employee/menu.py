from project0employee.create_employee import create_employee
from project0employee.expensefunctions import AddExpense, EditExpense, DeleteExpense, ViewExpenses, ViewExpenseHistory


#Main menu for the python employee program
def menu(user_id):
    while True:

        #Print main menu to screen
        print("\n====== Employee Menu ======")
        print("1. Create New Employee Account")
        print("2. Add Expense")
        print("3. Edit Expense")
        print("4. Delete Expense")
        print("5. View Expenses")
        print("6. View Expense History")
        print("7. Exit")

        #get user input
        option = int(input("Select an option: "))

        #match statement for options
        match option:
            case 1:
                create_employee()
            case 2:
                AddExpense(user_id)
            case 3:
                EditExpense(user_id)
            case 4:
                DeleteExpense(user_id)
            case 5:
                ViewExpenses(user_id)
            case 6:
                ViewExpenseHistory(user_id)
            case 7:
                print("Logging out...")
                break
            case _:
                print("Invalid option!")

    return False