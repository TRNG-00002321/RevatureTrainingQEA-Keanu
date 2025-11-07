import numpy as np

arr = np.array([1,2,3,4,5,6,7,8,9])
print(arr)
print(type(arr))

# Output
#[1 2 3 4 5]
#<class 'numpy.ndarray'>

arr = np.array(42)
print(arr)

arr =  np.array([1,2,3,4,5])
print(arr)

arr = np.array([[1,2,3],[4,5,6],[7,8,9]])
print(arr)

#Numpy arrays provides the ndim attribute that returns an integer
# that tells us how many dimensions the array has

a = np.array(42)
b = np.array([1,2,3,4,5])
c = np.array([[1,2,3],[4,5,6]])
d = np.array([[[1,2,3],[4,5,6]],[[7,8,9],[10,11,12]]])

print(a.ndim)
print(b.ndim)
print(c.ndim)
print(d.ndim)

#an array can have any number of dimensions. When the array is created you can
#define the number of dimensions using ndim
#arr = np.array([1,2,3,4], ndim=5)
print(arr)
print("Number of dimensions: ", arr.ndim)

#accessing 2 dimensional arrays
print(c[1][2])

#Array slicing [start:end:step]
arr = np.array([1,2,3,4,5,6])

#Normal slicing
print(arr[0:3])
#Slicing with step
print(arr[1:5:2])
#Slicing from index 4 to the end of the array
print(arr[4:])
#Slicing from beginning to index 4
print(arr[:4])

#Negative slicing: Using the minus operator to refer to an index from the end
#Slice from index 3 from the end to index 1 from the end
arr = np.array([1,2,3,4,5,6,7])
print(arr[-3:-1])

#Slicing 2-D arrays
#from the second element slice elements from index 1 to 4
arr = np.array([[1,2,3,4,5],[6,7,8,9,10]])
print(arr[1, 1:4])

#The shape of an array is the number of elements in each dimension
#Numpy arrays have an attribute called shape that returns a tuple with each index having
#the number of corresponding elements
arr = np.array([[1,2,3],[4,5,6],[7,8,9]])
print(arr.shape)

#Reshaping the array means changing the shape by adding or removing dimensions or
#change the number of elements in a dimension

arr = np.array([1,2,3,4,5,6,7,8,9,10,11,12])
newarr = arr.reshape(3,4)
print(newarr)

#Flattening an array means converting a multidimensional array ind a 1D array.
#We can use reshape(-1) to do this


arr1 = np.array([1, 2, 3])
arr2 = np.array([4, 5, 6])
arr = np.stack((arr1, arr2), axis=1)
print(arr)

arr = np.array([1, 2, 3, 4, 5, 6])
newarr = np.array_split(arr, 6)
print(newarr)

arr = np.array([6, 7, 8, 9])
x = np.searchsorted(arr, 9)
print(x)