"""
TODO: Implement a driver factory that:
1. Uses webdriver-manager for automatic driver management
2. Provides a context manager for safe browser cleanup
3. Supports headless mode via parameter
"""

from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@contextmanager
def create_chrome_driver(headless: bool = True):
    # YOUR CODE HERE
    # 1. Create ChromeOptions and configure headless if needed
    # 2. Set up Service with ChromeDriverManager
    # 3. Create driver, yield it, and ensure quit() in finally block
    # 1. Create ChromeOptions
    options = Options()
    if headless:
        options.add_argument("--headless=new")
        options.add_argument("--window-size=1920,1080")

    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service)

    try:
        yield driver
    finally:
        driver.quit()