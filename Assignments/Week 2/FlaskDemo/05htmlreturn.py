from flask import Flask, render_template

#app = Flask(__name__)

#specify the template folder name
app = Flask(__name__, template_folder='views')

#by default the template engine will pick up templates from a folder named templates
@app.route("/index")
def index():
    return render_template('hello2.html')

if __name__ == '__main__':
    app.run(debug=True)
