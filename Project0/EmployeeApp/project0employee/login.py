import getpass
import sqlite3
import database

#------------------------
# Login function
#------------------------

def login():

    #login interface
    print("\n=== Login ===")
    username = input("Username: ")
    password = getpass.getpass("Password: ")

    #connect to database
    conn = sqlite3.connect(database.DB_PATH)
    c = conn.cursor()

    #find user from users table
    c.execute("SELECT id, username FROM users WHERE username=? AND password=?", (username, password))
    user = c.fetchone()
    conn.close()

    #Returns user id if successful
    if user:
        print(f"\nWelcome, {user[1]}!")
        return user[0]  # return user_id
    else:
        print("Invalid login!")
        return None