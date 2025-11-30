import sqlite3
import database
import logging
logger = logging.getLogger(__name__)

#------------------------
# Login function
#------------------------

def login():

    #login interface
    print("\n=== Login ===")
    username = input("Username: ")
    password = input("Password: ")

    #connect to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

    #find user from users table
    c.execute("SELECT id, username FROM users WHERE username=? AND password=?", (username, password))
    user = c.fetchone()

    #Returns user id if successful
    if user:
        print(f"\nWelcome, {user[1]}!")
        logger.info(f"User {user[1]} logged in")
        return user[0]  # return user_id
    else:
        logger.error("Failed to log in")
        print("Invalid login!")
        return False