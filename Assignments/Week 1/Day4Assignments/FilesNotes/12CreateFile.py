# Creating a new file using "x" mode
# If the file already exists, it raises a FileExistsError
try:
    with open("newfile.txt", "x") as file:
        file.write("This file was just created.")
except FileExistsError:
    print("File already exists")