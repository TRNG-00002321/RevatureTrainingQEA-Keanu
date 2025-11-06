#returns sum of all elements in a list
def createList():
    list1 = [1, 2, 3, 4, 5]
    sum = 0

    for i in list1:
        sum += i

    return sum

#finds elements less than k and returns new list of those elements
def findLessThan(k: int, arr: list):
    less_list = []

    for i in range(arr.__len__()):
        if arr[i] < k:
            less_list.append(arr[i])

    return less_list

#returns average of elements in a list
def findAverage(arr: list):
    total = 0
    count = 0

    for i in range(arr.__len__()):
        if arr[i] > 0:
            total += arr[i]
            count += 1

    return total / count