import string


class ToDoListManager:
    def __init__(self, *task):
        self.ToDoList = dict(task)

    def addTask(self, task: tuple):
        self.ToDoList.update(task)

    def deleteTask(self, task: string):
        pass

