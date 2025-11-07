def ConvertCelsiustoFahrenheit():
    celsius_temps = [0, 10, 20, 30]
    fahrenheit_temps = list(map(lambda C: (C * 9/5) + 32, celsius_temps))
    print(fahrenheit_temps)

def CapitalizeListofNames():
    names = ["alice", "bob", "charlie"]

    capitalized_names = list(map(lambda name: name.capitalize(), names))
    print(capitalized_names)

def AddCorrespondingElements():
    list1 = [1, 2, 3]
    list2 = [4, 5, 6]

    added_list = list(map(lambda x,y: x + y, list2 , list1))
    print(added_list)

def ConcatenateStrings():
    first_names = ["John", "Jane"]
    last_names = ["Doe", "Smith"]

    concatenated_names = list(map(lambda x,y: x + " " + y, first_names , last_names))
    print(concatenated_names)

def string_length(string):
    length = len(string)
    return length

def CustomMapFunction():
    words = ["apple", "banana", "cherry"]

    lengths = list(map(string_length, words))

    print(lengths)

#Function call tests##########################################################################
ConvertCelsiustoFahrenheit()

CapitalizeListofNames()

AddCorrespondingElements()

ConcatenateStrings()

CustomMapFunction()