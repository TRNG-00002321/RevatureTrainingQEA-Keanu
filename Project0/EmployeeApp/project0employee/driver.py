from project0employee.database import init_db
from project0employee.login import login
from project0employee.menu import menu
from project0employee.prelogin import pre_login
import logging


def main():
    logging.basicConfig(level=logging.INFO,
                        format='%(asctime)s - %(levelname)s - %(message)s',
                        filename='app.log',
                        filemode='a')
    init_db()

    running = True

    while running:

        if(pre_login() == False):
            break

        user_id = int(login())

        if user_id:
            running = menu(user_id)

if __name__ == "__main__":
    main()