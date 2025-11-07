# readline() : Reads one line at a time
# (including the newline character)

with open("example.txt", "r") as file:
    line1 = file.readline()
    line2 = file.readline()
    print(line1, line2)