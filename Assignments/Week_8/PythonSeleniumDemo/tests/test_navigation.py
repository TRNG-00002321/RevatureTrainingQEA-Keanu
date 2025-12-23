"""
Test navigation functionality using Python Selenium.

Implement tests that:
1. Navigate to https://the-internet.herokuapp.com/
2. Click on "Form Authentication" link
3. Verify URL changed to /login
4. Use back/forward navigation
5. Capture screenshots at key points
"""
import os

from selenium.webdriver.common.by import By
import sys

sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver


def test_navigate_to_login_page():
    """
    Test: Navigate from home to login page

    Steps:
    1. Go to the-internet homepage
    2. Find and click "Form Authentication" link
    3. Assert URL contains "/login"
    4. Assert page contains "Login Page" heading
    """
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        # 1. Go to the homepage
        driver.get("https://the-internet.herokuapp.com/")

        # 2. Click "Form Authentication"
        driver.find_element(By.LINK_TEXT, "Form Authentication").click()

        # 3. Assert URL contains "/login"
        assert "/login" in driver.current_url

        # 4. Assert page contains "Login Page" heading
        heading = driver.find_element(By.TAG_NAME, "h2")
        assert heading.text == "Login Page"



def test_back_forward_navigation():
    """
    Test: Browser navigation (back/forward)

    Steps:
    1. Navigate to homepage
    2. Click a link to go to another page
    3. Use driver.back() to return
    4. Assert you're on homepage
    5. Use driver.forward() to go forward
    6. Assert you're on the second page again
    """
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")

        driver.find_element(By.LINK_TEXT, "Form Authentication").click()

        driver.back()

        assert "/login" not in driver.current_url

        driver.forward()

        # 4. Assert page contains "Login Page" heading
        assert "/login" in driver.current_url


def test_capture_screenshot():
    """
    Test: Screenshot capture

    Steps:
    1. Navigate to any page
    2. Take a full page screenshot
    3. Save it to screenshots/homepage.png
    """
    # YOUR CODE HERE

    screenshots_dir = "screenshots"
    screenshot_path = os.path.join(screenshots_dir, "homepage.png")

    # Ensure screenshots directory exists
    os.makedirs(screenshots_dir, exist_ok=True)

    with create_chrome_driver() as driver:
        # 1. Navigate to a page
        driver.get("https://the-internet.herokuapp.com/")

        # 2 & 3. Take and save screenshot
        driver.save_screenshot(screenshot_path)

    # Optional assertion: verify file was created
    assert os.path.exists(screenshot_path)