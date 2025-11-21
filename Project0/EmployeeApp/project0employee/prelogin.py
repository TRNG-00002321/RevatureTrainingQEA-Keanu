from project0employee.create_employee import create_employee


def pre_login():
    while True:

        #Print main menu to screen
        print("\n====== Employee Menu ======")
        print("1. Login")
        print("2. Create New Employee Account")
        print("3. Exit")

        choice = int(input("Enter your choice: "))

        if choice == 1:
            return True
        elif choice == 2:
            create_employee()
        elif choice == 3:
            return False
        else:
            print("Invalid choice. Please try again.")