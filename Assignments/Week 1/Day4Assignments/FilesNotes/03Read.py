# read() : reads the entire file

with open("example.txt", "r") as file:
    lines = file.read()
    print(lines)