import pandas as pd

#Pandas is a python library used for working with data sets. It has functions for
#analyzing, cleaning, exploring, and manipulating data

#panda understands series and dataframes
#series are 1D
#dataframes can be multidimensional or a table

#panda can clean messy data sets, and make them readable and relevant

#pandas gives you answers about the data like:
# is there a correlation between two or more columns
# what is the average value
# max value?
# min value
# Pandas is able to delete rows that are not relevant, or contains wrong values like empty or null values
# This is called cleaning the data
# Columns are correlated with itself as 1 and other columns as positive or negative

mydataset = {
  'cars': ["BMW", "Volvo", "Ford"],
  'passings': [3, 7, 2]
}

myvar = pd.DataFrame(mydataset)
print(myvar)

# a pandas series is like a column in a table it is a one dimensional array holding data of any type
a = [1, 7, 2]
myvar = pd.Series(a)
print(myvar)

#Can specify the indexes for the series
#If nothing is specified the indexes will be the numbers 0, 1, 2, etc

a = [1, 7, 2]
myvar = pd.Series(a, index = ["x", "y", "z"])
print(myvar)

#Can also use a key/value object like a dictionary when creating a series
calories = {"day1": 420, "day2": 380, "day3": 390}
myvar = pd.Series(calories)
print(myvar)

#######################################################################################################

#Dataframes
#A pandas dataframe is a 2D data structure like a 2D array or a table with rows and columns

data = {
  "calories": [420, 380, 390],
  "duration": [50, 40, 45]
}
#load data into a DataFrame object:
df = pd.DataFrame(data)
print(df)

#Locate Row
#Pandas uses the loc attribute to return one or more specified rows

#refer to the row index
print(df.loc[0])

#with the index argument you can name your own indexes

df = pd.DataFrame(data, index = ["day1", "day2", "day3"])
print(df)

############################################################################################

#Pandas read CSV

#A simple way to store big data sets is to use CSV files. Contains plain text and is a well known
#format that can be read by everyone including Pandas
df = pd.read_csv("data.csv")

#Use to_string to display the entire csv file otherwise only returns first and last 5 lines of a larger file
#print(df.to_string())
print(df)

#max_rows
#The number of rows is defined in Pandas option settings
print(pd.options.display.max_rows)

#head() method returns the headers and a specified number of rows starting from the top
df = pd.read_csv('data.csv')
print(df.head(10))

#There is also a tail() method for viewing the last rows of the DataFrame.
#The tail() method returns the headers and a specified number of rows, starting from the bottom.

#Remove Rows
#One way to deal with empty cells is to remove rows that contain empty cells.
#This is usually OK, since data sets can be very big, and removing a few rows will not have a big impact on the result.
df = pd.read_csv('data.csv')
new_df = df.dropna()
print(new_df.to_string())
# By default, the dropna() method returns a new DataFrame, and will not change the original.
