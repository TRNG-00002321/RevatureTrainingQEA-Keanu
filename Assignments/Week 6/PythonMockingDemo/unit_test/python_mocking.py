import unittest
from unittest.mock import Mock

def greet(func):
    return "Hello, " + func()

class TestMockBasic(unittest.TestCase):
    def test_mock_return_value_and_assert_call(self):
        fake_func = Mock(return_value="World")
        result = greet(fake_func)

        # behavior check
        self.assertEqual(result, "Hello, World")

        # validation: was called once
        fake_func.assert_called_once()
        # validation: called with no arguments
        fake_func.assert_called_once_with()