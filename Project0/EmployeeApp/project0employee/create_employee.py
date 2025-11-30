import sqlite3
import logging

import mysql.connector

from project0employee import database

logger = logging.getLogger(__name__)


def create_employee():
    #Connects to database
    conn = database.DB_Connection
    c = conn.cursor(prepared=True)

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
        logger.info('User created successfully')
    except mysql.connector.errors.Error as e:
        #throw an exception if username exists in table
        print("Username already exists!")
        logger.error('User creation failed', e.msg)
        return

