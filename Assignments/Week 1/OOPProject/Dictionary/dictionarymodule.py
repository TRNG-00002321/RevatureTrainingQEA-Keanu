def dictionary(arr: list):
    #nested for loop for finding first repeating index
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[j] == arr[i]:
                return i + 1