def printRepeat(a, n):
    for i in range(n):
        print(a, end="")

    print("\n")

def printRepeatWithSpaces(a,b,c):
    for i in range(a):
        print(a, end="")
        print(c, end="")

    for i in range(b):
        print(b, end="")
        print(c, end="")

    print("\n")

def variableTask(x):
    if type(x) == str:
        return print(x)
    elif type(x) == int:
        return x + 10
    elif type(x) == float:
        return x * 10
    else:
        return -1

def addition(x, y):
    return x + y
def subtraction(x, y):
    return x - y
def multiplication(x, y):
    return x * y
def division(x, y):
    try:
        return x / y
    except ZeroDivisionError:
        return "division by zero"
    except TypeError as e:
        return f"incorrect type: {e}"
def modulo(x, y):
    return x % y

def swap(a, b):
    temp = a
    a = b
    b = temp
    return a, b


