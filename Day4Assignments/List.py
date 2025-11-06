#def listsquares():
#   arr = [1,2,3,4,5]
#
#   for i in arr:
#       print(i * i)
from functools import reduce

from setuptools.archive_util import unpack_zipfile

#map(function, iterable)
#map function executes a function on each of a value in a iterable(e.g., list, tuple, string)
squared_numbers = list(map(lambda x: x**2, [1, 2, 3, 4, 5]))
print(squared_numbers)

#filter(function, iterable)
#constructs and iterator from elements of an iterable for which the given function returns true.
#the function must return a boolean value
arr = [1,2,3,4,5,6,7,8,9,10]
even_numbers = list(filter(lambda x: x % 2 == 0, arr))
print(even_numbers)

#reduce(function, iterable[, initializer])
#Applies a function of two arguments cumulatively to the items of an iterable from left to right
#reducing the iterable to a single value. Requires importing from the functools module
sum_numbers = reduce(lambda x, y: x + y, [1, 2, 3, 4, 5])
print(sum_numbers)

##############################################################################################

#define 2 lists first one containing 3 names and second list containing the ages
names = ["John", "Joe", "Jacob"]
ages = [30,20,50]

#Zip function
#The zip() function in python is a built-in utility that combines multiple iterable objects
#(like lists, tuple, or strings) int a single iterable of tuples. It pairs corresponding elements
#from each input iterable based on their index

combined_data = zip(names, ages)
print(list(combined_data))

#Unzipping
#You can effectively "unzip" a zipped object using the * (unpacking) operater with zip() again

zipped_data = [('Alice', 30), ('Bob', 20), ('Charlie', 50)]
unzipped_names, unzipped_ages = zip(*zipped_data)

print(unzipped_names)
print(unzipped_ages)




