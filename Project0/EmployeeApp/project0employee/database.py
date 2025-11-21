import sqlite3

#absolute path to database file
DB_PATH = r"C:\Users\Owner\OneDrive\Desktop\RevatureTrainingQEA-Keanu\Project0\Database\expenses.db"

# -------------------------------
# Database Initialization
# -------------------------------

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
        print("Created default user: test / pass")

    conn.commit()
    conn.close()

#Testing database creation######################
#def main():
#    init_db()

#if __name__ == "__main__":
#    main()