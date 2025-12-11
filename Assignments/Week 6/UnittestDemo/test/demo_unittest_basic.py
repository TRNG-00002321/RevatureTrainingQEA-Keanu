import sys
import unittest

from src.Calculator import Calculator


class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.calculator = Calculator()

    def test_add(self):
        n1=1
        n2=4
        expectedResult=5
        result = self.calculator.add(n1, n2)
        self.assertEqual(result, expectedResult)

    def test_isEven(self):
        n = 4
        expectedResult = True
        result = self.calculator.is_even(n)
        self.assertTrue(result, expectedResult)

    @unittest.skip
    def test_sub(self):
        n1 = 3
        n2 = 1
        expectedResult = 2
        result = self.calculator.subtract(n1, n2)
        self.assertEqual(result, expectedResult)

    @unittest.skipIf(sys.platform == 'win32', "Skipping on Windows")
    def test_divide_by_zero(self):
        with self.assertRaises(ZeroDivisionError):
            self.calculator.divide(1,0)

    def test_divide_by_zero_context(self):
        with self.assertRaises(ZeroDivisionError) as context:
            self.calculator.divide(1, 0)

        self.assertEqual(str(context.exception), "Cannot divide by zero")

    def tearDown(self):
        self.calculator = None