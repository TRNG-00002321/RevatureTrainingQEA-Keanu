import mysql.connector

conn = mysql.connector.connect(host="localhost",user="root",password="ppp444",database="classicmodels")
cursor = conn.cursor()
print("Database opened successfully")

cursor.execute("SELECT * FROM employees")
rows = cursor.fetchone()
print(rows)
