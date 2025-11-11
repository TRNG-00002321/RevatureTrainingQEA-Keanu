#ToDoListManager class and methods
import json
from flask import Flask, request, render_template, redirect, url_for

app = Flask(__name__, template_folder='templates')

tasklist = []

def LoadToDoList():
    with open('ToDoList.json', 'r') as json_file:
        global tasklist
        tasklist = json.load(json_file)

def CreateTask(new_task):
    global tasklist

    new_data = {"Task": new_task, "Status":"In Progress"}

    with open('ToDoList.json', 'r') as json_file:
        tasklist = json.load(json_file)

    with open('ToDoList.json', 'w') as json_file:
        tasklist.append(new_data)
        json.dump(tasklist, json_file)

def UpdateTask(task_name):
    global tasklist
    with open('ToDoList.json', 'r') as json_file:
        tasklist = json.load(json_file)

    with open('ToDoList.json', 'w') as json_file:
        updated_task = next((t for t in tasklist if t["Task"] == task_name), None)
        updated_task["Status"] = "Completed"
        json.dump(tasklist, json_file)

def DeleteTask(task_name):
    global tasklist
    with open('ToDoList.json', 'r') as json_file:
        tasklist = json.load(json_file)

    with open('ToDoList.json', 'w') as json_file:
        deleted_task = next((t for t in tasklist if t["Task"] == task_name), None)
        tasklist.remove(deleted_task)
        json.dump(tasklist, json_file)


@app.route('/')
def listmanager():
    global tasklist
    LoadToDoList()
    return render_template('ToDoList.html', tasklist = tasklist)

@app.route('/add', methods=['POST'])
def addTask():
    global tasklist
    CreateTask(request.form['task'])
    return redirect(url_for('listmanager'))

@app.route('/update', methods=['POST'])
def updateTask():
    global tasklist
    UpdateTask(request.form['task'])
    return redirect(url_for('listmanager'))

@app.route('/delete', methods=['POST'])
def deleteTask():
    global tasklist
    DeleteTask(request.form['task'])
    return redirect(url_for('listmanager'))


if __name__ == '__main__':
    app.run(debug=True)
