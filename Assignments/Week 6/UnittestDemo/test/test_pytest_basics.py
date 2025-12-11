import pytest
from src.Calculator import Calculator

@pytest.fixture
def calculator():
    return Calculator()

@pytest.mark.skip(reason="Not implemented")
def test_calculator_add(calculator):
    #calculator = Calculator()
    result = calculator.add(1, 2)
    assert result == 3

def test_calculator_iseven(calculator):
    #calculator = Calculator()
    assert calculator.is_even(4) is True
    assert not calculator.is_even(3)

def test_divide_by_zero(calculator):
    #calculator = Calculator()
    with pytest.raises(ZeroDivisionError) as context:
        calculator.divide(1, 0)

    assert "zero" in str(context.value).lower()

@pytest.mark.parametrize(
    "a,b,result",
    [
        (1, 2, 3),
        (4, 5, 9),
        (6, 7, 13)
    ])
def test_add_parameterized(calculator, a, b, result):
    assert calculator.add(a, b) == result