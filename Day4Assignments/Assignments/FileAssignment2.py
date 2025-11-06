#Copies binary data from one image file to another
with open("image.jpg", "rb") as data:
    binary = data.read()
    with open("copiedimage.jpg", "wb") as copied_data:
        copied_data.write(binary)