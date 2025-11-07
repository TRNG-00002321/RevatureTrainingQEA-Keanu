#parameters are file name and mode
#modes: r = read, w = create or override mode, a = append mode, x = create new file or throws error if file exists, b = binary mode, t = text mode
#r and t are the default modes
#w creates a new file or overrides data in existing file

#opens file
file = open("example.txt", "r")

#puts file's content into a string
content = file.read()

#prints file content
print(content)

#closes file
file.close()
