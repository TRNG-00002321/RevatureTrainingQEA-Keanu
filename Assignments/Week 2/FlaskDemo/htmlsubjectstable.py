from flask import Flask, render_template

classes = {"Physics":"80", "Chemistry":"60", "Math":"90"}
app = Flask(__name__)

@app.route('/subjects')
def subjects(classes):
    render_template('subjectstable.html', classes=classes)

if __name__ == '__main__':
    app.run(debug=True)