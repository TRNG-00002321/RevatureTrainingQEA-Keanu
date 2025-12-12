# reads a text file and returns a list of numbers
def read(filename):
    with open(filename) as f:
        lines = f.readlines()
        return [float(lines[0].strip()) for line in lines]

#return the sum of numbers in a text file
def calculate_total(filename):
    numbers = read(filename)
    return sum(numbers)

