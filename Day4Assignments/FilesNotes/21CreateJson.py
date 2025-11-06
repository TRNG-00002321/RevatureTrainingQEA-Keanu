import json

#Define the data you want to write into a dictionary or list
my_data = {
    "name": "Alice",
    "age": 30,
    "city":" New York",
    "isStudent": False,
    "courses": ["Math","Science"]
}

#Open a file in write mode('w'), if the file doesnt exist it will be created
#If it exists, its content will be overwritten
with open("data.json", "w") as file:
    #Dump the python data into the file in JSON format
    json.dump(my_data, file, indent=4) # indent=4 makes the output human-readable