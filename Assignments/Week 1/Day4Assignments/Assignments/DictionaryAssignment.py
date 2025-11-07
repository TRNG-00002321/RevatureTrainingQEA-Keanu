Countries = {"USA":"Washington DC", "UK":"London",
             "Mexico":"Mexico City", "Germany":"Berlin",
             "France":"Paris"}

Students = {"Alice": 60, "Bob": 90, "Carol": 55, "David": 80, "Edinburgh": 78}

Employees = {"1":{"name":"John", "age": 30, "salary": 5000},
             "2":{"name":"Alice", "age": 40, "salary": 8000},
             "3":{"name":"Bob", "age": 25, "salary": 3000}}

def FindCapital(country):
    if country in Countries:
        return Countries[country]

def FindStudentwithHighestScore(students):
    student = max(students, key=students.get)
    return student

def RaiseSalaries(employees):

    raised_salaries = {}
    for employee in employees.values():
        pass#raised_salaries
    #new_salaries = dict(map(lambda key: (key["salary"] * .1) += key["salary"], employees))
    return employees

#Function call tests##########################################################################
print(FindCapital("France"))

print(FindStudentwithHighestScore(Students))

print(RaiseSalaries(Employees))