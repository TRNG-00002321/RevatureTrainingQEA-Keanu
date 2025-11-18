import sqlite3
from project0employee import database


def create_employee():
    #Connects to database
    conn = sqlite3.connect(database.DB_PATH)
    c = conn.cursor()

    #make sure username is unique username######################

    #Asks user for new username and password
    print("Creating new employee account...")
    username = input('Enter your username: ')
    password = input('Enter your password: ')

    #Check if username is unique
    try:
        #insert new employee into users table
        c.execute("""
                    INSERT INTO users (username, password, role) VALUES (?, ?, ?)
        """, (username, password, "employee"))

        conn.commit()
        conn.close()
    except sqlite3.IntegrityError:
        #throw an exception if username exists in table
        print("Username already exists!")
        conn.close()
        return

