#using the with block you don't need to close the file; it's handled automatically
with open("example.txt", "r") as file:
    content = file.read()
    print(content)