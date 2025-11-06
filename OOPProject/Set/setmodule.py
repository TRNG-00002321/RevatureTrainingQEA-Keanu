def createSet(arr: list, x: int):
    my_set = set(arr)

    try:
        my_set.remove(x)
        print(f"erased + {x}")
    except:
        print("not found")


    return my_set

