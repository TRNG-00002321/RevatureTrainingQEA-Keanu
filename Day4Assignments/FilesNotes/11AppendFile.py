#Appending to a File : Use "a" mode to add content to an existing file
#without deleting its contents

with open("output.txt", "a") as file:
    file.write("This line is appended.\n")