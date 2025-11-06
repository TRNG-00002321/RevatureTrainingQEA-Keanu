import json

#Script for writing to a json file
def WriteToFile():

    #dictionary containing data
    data = {"name":input("Enter name: "), "age":int(input("Enter age: ")), "city":input("Enter city: ")}
    database = []

    try:
        #opens database json file
        with open("database.json", "r") as file:
            database = json.load(file)
    except (FileNotFoundError, json.decoder.JSONDecodeError):
        print("Database is empty")

    #appends new data to database list
    database.append(data)

    #writes new list to json file
    with open("database.json", "w") as file:
        json.dump(database, file, indent=4)

WriteToFile()


