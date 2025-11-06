# Iterating over lines : you can loop through a file line by line

with open("example.txt", "r") as file:
    for line in file:
        print(line.strip()) # Removes newline characters 