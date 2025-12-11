import pytest

@pytest.fixture(scope="module")
def sample_data():
    data = {"name":"Alex","age":20}
    yield data
    #do something

