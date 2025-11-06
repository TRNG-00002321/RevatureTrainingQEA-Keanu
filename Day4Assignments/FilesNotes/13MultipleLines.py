# Writing multiple lines
#You can write multiple lines using writelines()
# which takes a list of strings

lines = ["line1\n", "line2\n", "line3\n"]
with open("multilines.txt", "w") as file:
    file.writelines(lines)
