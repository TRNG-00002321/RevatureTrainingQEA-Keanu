import ToDoListManagerModule as tm

#Dictionary of tasks
tasks = {"Task1":"In Progress", "Task2":"In Progress",
         "Task3":"In Progress", "Task4":"In Progress",
         "Task5":"In Progress"}

#manager object
manager = tm.ToDoListManager(tasks)

#Testing add task
task = ({"Task6": "In Progress"})
manager.addTask(task)
print(manager.ToDoList)

#Testing remove task
manager.deleteTask("Task5")
print(manager.ToDoList)

#Testing get task
print(manager.getTaskStatus("Task1"))

#Testing mark task as complete
manager.markTaskDone("Task1")
print(manager.getTaskStatus("Task1"))

#Testing saving tasks to json file
manager.SaveTasks()