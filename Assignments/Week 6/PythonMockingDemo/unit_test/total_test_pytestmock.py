from src import total

def test_calculate_total_pytest(mocker):
    total.read = mocker.Mock()
    total.read.return_value = [1.0, 2.0, 3.0]

    result = total.calculate_total('')

    assert result == 6.0

def test_calculate_total_patch_pytest(mocker):
    mock_func = mocker.Mock()
    mock_func.return_value = [1.0, 2.0, 3.0]

    mocker.patch('src.total.read', return_value=mock_func.return_value)

    result = total.calculate_total('')
    assert result == 6.0

