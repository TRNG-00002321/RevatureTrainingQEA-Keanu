def createList():
    list1 = [1, 2, 3, 4, 5]
    sum = 0

    for i in list1:
        sum += i

    return sum

def findLessThan(k: int, arr: list):
    less_list = []

    for i in range(arr.__len__()):
        if arr[i] < k:
            less_list.append(arr[i])

    return less_list

def findAverage(arr: list):
    total = 0
    count = 0

    for i in range(arr.__len__()):
        if arr[i] > 0:
            total += arr[i]
            count += 1

    return total / count