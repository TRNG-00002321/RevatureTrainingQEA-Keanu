from flask import Flask, request, redirect, url_for
from hello import user

app = Flask(__name__)

@app.route('/login/<username>')
def hello_user(username):
    if username.lower() == 'admin':
        return "Hello Admin, " + username
    else:
        return "Hello Guest, " + username

#default route method is GET
@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        #getting data from the form with request
        username = request.form['nm']
        #return "Welcome " + username.upper()
        return redirect(url_for('hello_user', username=username))
    else:
        #args come after the question mark in the url
        username = request.args.get('nm')
        #return "Welcome " + username.upper()
        return redirect(url_for('hello_user', username=username))

if __name__ == '__main__':
    app.run(debug=True)
