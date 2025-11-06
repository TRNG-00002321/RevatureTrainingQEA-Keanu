import json

#Open the JSON file in read mode
with open("data.json", "r") as file:
    # Load the JSON data from the file into a python dictionary
    data = json.load(file)

#Now 'data' is a Python dictionary containing the information from data.json
print(data)

#create dictionary with name age and city then write to file with append mode then read in a different program