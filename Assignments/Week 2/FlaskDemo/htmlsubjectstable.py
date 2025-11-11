from flask import Flask, render_template

classes = {"Physics":"80", "Chemistry":"60", "Math":"90"}
app = Flask(__name__)

@app.route('/')
def subjects():
    return render_template('subjectstable.html', subjects=classes)

if __name__ == '__main__':
    print(app.root_path)
    app.run(debug=True)
