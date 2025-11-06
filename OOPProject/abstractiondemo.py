from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def speak(self):
        pass

    @abstractmethod
    def area(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def speak(self):
        return "Circle"

    def area(self):
        return f"Area is {(self.radius * self.radius) * 3.14}"



class Rectangle(Shape):
    def __init__(self, base, height):
        self.base = base
        self.height = height

    def speak(self):
        return "Rectangle"

    def area(self):
        return f"Area = {self.base * self.height}"

class Triangle(Shape):
    def __init__(self, base, height):
        self.base = base
        self.height = height

    def speak(self):
        return "Triangle"

    def area(self):
        return f"Area = {1/2 * (self.base * self.height)}"

circle = Circle(10)
print(circle.speak())
print(circle.area())

rectangle = Rectangle(5, 5)
print(rectangle.speak())
print(rectangle.area())

triangle = Triangle(5, 5)
print(triangle.speak())
print(triangle.area())

#Abstract classes cannot be instantiated
#shape = Shape()
#print(shape.Shape)