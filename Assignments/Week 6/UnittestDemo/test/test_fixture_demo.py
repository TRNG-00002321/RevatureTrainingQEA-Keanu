import pytest

@pytest.fixture
def database_connection():
    # Set up: establish a database connection
    print("Establishing database connection...")
    connection = "simulated_db_connection" #replace with actual connection logic
    yield connection #Yield the connection to the test

    print("Closing database connection...")
    # connection.close() #Replace with actual close logic

def test_database_operation(database_connection):
    print(f"Using Database Connection: {database_connection}")
    # Perform database operations using the connection
    assert database_connection == "simulated_db_connection"

def test_conftest_user(sample_data):
    assert sample_data["name"] == "Alex"
    assert sample_data["age"] == 20