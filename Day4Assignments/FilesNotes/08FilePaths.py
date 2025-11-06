# Handline file paths : use raw strings or os.path for opening a file

import os

path = os.path.join("example.txt")
with open(path, "r") as file:
    print(file.read())