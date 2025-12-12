import unittest
from unittest.mock import Mock, MagicMock, patch

from src import total


class TotalTest(unittest.TestCase):
    def test_calculate_total(self):
        total.read=MagicMock(return_value=[1.0, 2.0, 3.0])
        result = total.calculate_total('')
        self.assertEqual(6, result)
        total.read.assert_called_once_with('')

    def test_calculate_test_patch(self):
        with patch('src.total.read') as mock_read:
            mock_read.return_value=[2,3,4]
            result = total.calculate_total('')
            self.assertEqual(9, result)

    @patch('src.total.read')
    def test_calculate_test_patch_decorator(self, mock_read_decorator):
        mock_read_decorator.return_value = [2,3,4]
        result = total.calculate_total('')
        self.assertEqual(9, result)

    def multiply_values(self, values):
        result = 1
        for v in values:
            result *= v
        return result

    @patch('src.total.read')
    def test_multiply_values(self, mock_read_decorator):
        mock_read_decorator.return_value = [1,2,3,4]
        with patch('src.total.sum', side_effect = self.multiply_values):
            result = total.calculate_total('')

        self.assertEqual(24, result)
        mock_read_decorator.assert_called_once_with('')

        #if in a list there is a negative number then raise an exception
        #Side effect for handling negative number
    def negative_check_side_effect(self, values):
        if any(v < 0 for v in values):
            raise ValueError("Negative values not allowed")
        return sum(values)

    @patch('src.total.read')
    def test_negative_check_side_effect(self, mock_read_decorator):
        mock_read_decorator.return_value = [-2,3,4]
        with patch('src.total.sum', side_effect = self.negative_check_side_effect):
            self.assertRaises(ValueError, total.calculate_total, '')
