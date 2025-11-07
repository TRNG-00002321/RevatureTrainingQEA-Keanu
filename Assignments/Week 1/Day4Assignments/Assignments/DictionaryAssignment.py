Countries = {"USA":"Washington DC", "UK":"London",
             "Mexico":"Mexico City", "Germany":"Berlin",
             "France":"Paris"}

Students = {"Alice": 60, "Bob": 90, "Carol": 55, "David": 80, "Edinburgh": 78}

Employees = {"1":{"name":"John", "age": 30, "salary": 5000},
             "2":{"name":"Alice", "age": 40, "salary": 8000},
             "3":{"name":"Bob", "age": 25, "salary": 3000}}

#1
def FindCapital(country):
    if country in Countries:
        return Countries[country]

#2
def FindStudentwithHighestScore(students):
    student = max(students, key=students.get)
    return student

#3
def RaiseSalaries(employees):
    for employee in employees.values():
        #raise salary by 10%
        employee["salary"] = int(employee["salary"] * 1.10)
    return employees

#4
def addKey(dictionary, key):
    dictionary.update(key)
    return dictionary

#5
def concatenateDict(dictionary_1, dictionary_2):
    dictionary_1.update(dictionary_2)
    return dictionary_1

#6
def findKey(dictionary, key):
    if key in dictionary:
        return f"{key} is in dictionary"
    else:
        return "Key not found"

#7
def iterateDict(dictionary):
    for key, value in dictionary.items():
        print(f"{key}: {value}")

#Function call tests##########################################################################
print(FindCapital("France"))

print(FindStudentwithHighestScore(Students))

print(RaiseSalaries(Employees))

dictionary = {"Name" : "Ram" , "Age" : 23}
add_key = {"City" : "Salem"}

print(addKey(dictionary, add_key))

Dictionary_1 = {"Name" : "Ram" , "Age" : 23}
Dictionary_2 = {"City" : "Salem", "Gender" : "Male"}

print(concatenateDict(Dictionary_1, Dictionary_2))

print(findKey(dictionary, "Name"))

iterateDict(dictionary)

