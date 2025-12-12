import unittest
from unittest.mock import Mock

from src import odometer


class TestOdometer(unittest.TestCase):
    def test_alert_normal(self):
        odometer.speed = Mock(return_value=70)

        assert odometer.alert() == False

    def test_alert_zero(self):
        odometer.speed = Mock(return_value=0)
        assert odometer.alert() == True

    def test_alert_negative(self):
        odometer.speed = Mock(return_value=-1)
        assert odometer.alert() == True

    def test_alert_upper_bound(self):
        odometer.speed = Mock(return_value=121)
        assert odometer.alert() == True

    def test_alert_lower_bound(self):
        odometer.speed = Mock(return_value=59)
        assert odometer.alert() == True