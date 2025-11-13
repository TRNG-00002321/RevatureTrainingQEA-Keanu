import pandas as pd
import sqlite3 as sql

class Employee:
    expenses = pd.DataFrame()

    def Login(self):

        username = input("Enter your username: ")
        password = input("Enter your password: ")


