def createSet(arr: list, x: int):
    my_set = set(arr) #new set

    try:
        #removes all elements of x
        my_set.remove(x)
        print(f"erased + {x}")
    except:
        #prints not found if element doesn't exist
        print("not found")

    return my_set

