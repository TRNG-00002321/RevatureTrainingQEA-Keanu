from project0employee.database import init_db
from project0employee.login import login
from project0employee.menu import menu


def main():
    init_db()

    running = True

    while running:
        user_id = int(login())

        if user_id:
            running = menu(user_id)

if __name__ == "__main__":
    main()