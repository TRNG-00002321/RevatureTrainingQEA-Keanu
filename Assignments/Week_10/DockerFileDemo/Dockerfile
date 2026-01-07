#From is the first command in a dockerfile
FROM python:3.11

#Set the working directory in the app
WORKDIR /app

#copy the requirements file from the host machine to the working directory in the container
COPY requirements.txt .

# install the dependencies specified in the requirements file
RUN pip install --no-cache-dir -r requirements.txt

# copt the rest of the application code from the host machine to the working directory in the container
COPY . .

#expose the port 5000 for the application
EXPOSE 5000

#run the application using the command below whenever the container starts
CMD ["python","app.py"]