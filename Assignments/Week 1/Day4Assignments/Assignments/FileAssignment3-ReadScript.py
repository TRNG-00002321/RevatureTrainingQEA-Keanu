import json

def ReadFromFile():

    #Opens json database and loads data
    with open("database.json", "r") as database:
        database = json.load(database)
        Search(database)

#Function for searching database
def Search(database):

    #Asks user for search input
    search = input("Enter search term: ")

    #searches each person in database and prints result
    for person in database:
        if search == person["name"]:
            print(person)
            break
        elif int(search) == person["age"]:
            print(person)
            break
        elif search == person["city"]:
            print(person)
            break


ReadFromFile()
