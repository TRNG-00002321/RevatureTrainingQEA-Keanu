#copies one files content to another 
with open("file1.txt", "r") as file:
    lines = file.read()
    with open("copiedfile.txt", "w") as copiedfile:
        copiedfile.write(lines)