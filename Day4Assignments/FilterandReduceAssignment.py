from functools import reduce

def FilterStringsByLength():
    words = ["apple", "banana", "cat", "dog", "elephant", "frog"]

    filtered_words = list(filter(lambda x: len(x) > 5, words))
    print (filtered_words)

def FilterStudentsByGrade():
    students = [
        {"name": "Alice", "grade": 85},
        {"name": "Bob", "grade": 92},
        {"name": "Charlie", "grade": 78},
        {"name": "David", "grade": 95}
    ]

    filtered_students = list(filter(lambda x: x["grade"] >= 90, students))
    print (filtered_students)

def ConcatenateStrings():
    words = ["Python", "is", "awesome", "!"]

    word = reduce(lambda x, y: x + y, words)

    print (word)

def FindMaxElement():
    numbers = [10, 3, 25, 7, 18]

    num = reduce(max, numbers)
    print(num)

def FlattenListofLists():
    list_of_lists = [[1, 2], [3, 4], [5, 6]]

    reduced_list = reduce(lambda x, y: x + y, list_of_lists)
    print(reduced_list)

#Function call tests##########################################################################
FilterStringsByLength()

FilterStudentsByGrade()

ConcatenateStrings()

FindMaxElement()

FlattenListofLists()