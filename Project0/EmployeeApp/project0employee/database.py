import logging
import sqlite3
import os

#absolute path to database file
#dir_path = os.path.dirname(os.path.realpath(__file__))
#os.path.join(dir_path, "expenses.db")
DB_PATH = r"C:\Users\Owner\OneDrive\Desktop\RevatureTrainingQEA-Keanu\Project0\Database\expenses.db"

# -------------------------------
# Database Initialization
# -------------------------------
logger = logging.getLogger(__name__)

def init_db():
    conn = sqlite3.connect(DB_PATH)
    c = conn.cursor()

    # Users table
    c.execute("""
        CREATE TABLE IF NOT EXISTS users (
            id INTEGER PRIMARY KEY,
            username VARCHAR(100) UNIQUE,
            password VARCHAR(100),
            role VARCHAR(20)
        )
    """)

    # Expenses table
    c.execute("""
        CREATE TABLE IF NOT EXISTS expenses (
            id INTEGER PRIMARY KEY,
            user_id INTEGER,
            amount REAL CHECK ( amount > 500 ),
            description VARCHAR(100),
            date TEXT,
            FOREIGN KEY (user_id) REFERENCES users(id)
        )
    """)

    # Approvals table
    c.execute("""
        CREATE TABLE IF NOT EXISTS approvals (
            id INTEGER PRIMARY KEY,
            expense_id INTEGER,
            status TEXT,
            reviewer INTEGER,
            comment TEXT,
            review_date TEXT,
            FOREIGN KEY (expense_id) REFERENCES expenses(id)
        )
    """)

    conn.commit()

    # Create a default user if none exists
    c.execute("SELECT * FROM users")
    if not c.fetchall():
        c.execute(
            "INSERT INTO users (username, password, role) VALUES (?, ?, ?)",
            ("test", "pass", "employee")
        )
        logger.info("Creating default user: test / pass")

    conn.commit()
    conn.close()

    logger.info("Database created successfully")

#Testing database creation######################
#def main():
#    init_db()

#if __name__ == "__main__":
#    main()