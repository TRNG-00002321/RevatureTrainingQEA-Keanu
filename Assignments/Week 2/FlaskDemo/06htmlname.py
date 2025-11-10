from flask import Flask, render_template

app = Flask(__name__)

@app.route('/hello/<name>')
def hello_name(name):
    return render_template('helloname.html', name=name)

@app.route('/marks/<int:score>')
def marks(score):
    return render_template('scores.html', marks=score)

if __name__ == '__main__':
    app.run(debug=True)

    #Create a dictionary of marks in the following subjects: Physics chemistry and math
    #Assign the marks according to your choice and display them in a table format in html

    #Use the same to do list manager and create CRUD functionality