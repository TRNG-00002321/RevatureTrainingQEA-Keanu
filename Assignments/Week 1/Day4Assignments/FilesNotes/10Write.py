#Writing to a file : use "w" mode to write to a file
#If the file exists it will be overwritten

with open("output.txt", "w") as file:
    file.write("This is the first line\n")
    file.write("This will overwrite any existing content\n")