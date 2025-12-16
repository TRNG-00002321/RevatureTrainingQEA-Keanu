import requests

def test_basics():
    response = requests.get('https://jsonplaceholder.typicode.com/users/1')
    print(response.status_code)
    print(response.json())
    print(response.text)

    assert response.status_code == 200

def test_parameters():
    params = {"postId": 1}
    response = requests.get('https://jsonplaceholder.typicode.com/comments', params=params)

    assert response.status_code == 200

def test_post():
    user = {
    "name": "John Doe",
    "email": "john@example.com",
    "role": "user"
    }

    response = requests.post('https://jsonplaceholder.typicode.com/users', json=user)

    assert response.status_code == 201

def test_GET_404():

    response = requests.get('https://jsonplaceholder.typicode.com/users/999')

    assert response.status_code == 404