import json
from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__, template_folder="templates")

print(app.root_path)

projects = []

def LoadProjects():
    with open('ProjectInfo.json', 'r') as json_file:
        global projects
        projects = json.load(json_file)

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/project')
def project():
    global projects
    LoadProjects()
    return render_template('project.html', projects=projects)

@app.route('/contact')
def contact():
    return render_template('contact.html')


if __name__ == '__main__':
    app.run(debug=True)