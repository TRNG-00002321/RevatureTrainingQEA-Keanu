from flask import Flask, redirect, url_for

app = Flask(__name__)

#based on an endpoint flask calls a view function
#view functions are displayed on the browser
@app.route('/')
def hello_world():
    return "Hello World!"

@app.route('/hello')
def hello_again():
    return "Hello World Again!"

#variable should be in diamond braces to pass into function
@app.route('/hello/<name>')
def hiname(name):
    return "Hi, %s!" % name.upper()

@app.route('/square/<int:num>')
def square(num):
    return str(num * num)

@app.route('/circle/<float:num>')
def circleArea(num):
    return str(num * num * 3.14)

@app.route('/sum/<int:num>+<int:num2>')
def sum(num, num2):
    return str(num + num2)

@app.route('/admin/<admin>')
def hello_admin(admin):
    return "Hello Admin, %s!" % admin.upper()

@app.route('/user/<username>')
def hello_guest(username):
    return "Hello Guest, %s!" % username.upper()

@app.route('/login/<username>')
def user(username):
    if username.lower() == "admin":
        #redirects to hello_admin method with url_for
        #the url_for function is used dynamically building a url for a specific function
        #1st argument is function and 2nd is variable you are passing to function
        return redirect(url_for('hello_admin', admin=username))
    else:
        return redirect(url_for('hello_guest', username=username))

def hithere():
    return "hi there"

#another way to define an endpoint
app.add_url_rule('/hi', view_func=hithere)

#starts the server
if __name__  == '__main__':
    app.run(debug=True)
