import pandas as pd

#Big data sets are often stored, or extracted as JSON.
#JSON is plain text, but has the format of an object, and is well known in the world of programming, including Pandas.
#Load the JSON file into a DataFrame:
df = pd.read_json('data.json')
print(df.to_string())