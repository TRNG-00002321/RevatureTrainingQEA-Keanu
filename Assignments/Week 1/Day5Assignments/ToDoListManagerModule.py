import json

#ToDoListManager class and methods
class ToDoListManager:
    def __init__(self, task: dict):
        self.ToDoList = task

    def addTask(self, task: dict):
        self.ToDoList.update(task)

    def deleteTask(self, task_name: str):
        self.ToDoList.pop(task_name)

    def getTaskStatus(self, task_name: str):
        return self.ToDoList[task_name]

    def markTaskDone(self, task_name: str):
        self.ToDoList[task_name] = "Complete"

    def SaveTasks(self):
        with open('ToDoList.json', 'w') as save_file:
            json.dump(self.ToDoList, save_file)




