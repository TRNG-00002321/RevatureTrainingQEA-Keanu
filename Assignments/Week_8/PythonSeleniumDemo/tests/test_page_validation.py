"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""

from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver

def test_page_title():
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")

        assert driver.title == "The Internet"

def test_heading_text():
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")

        heading = driver.find_element(By.TAG_NAME, "h1")

        assert "Welcome to the-internet" in heading.text

def test_links_present():
    """Verify that all example links are present on the page."""
    # YOUR CODE HERE
    # Use find_elements to get all links
    # Use list comprehension to extract link texts
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")

        # Get all link elements
        links = driver.find_elements(By.TAG_NAME, "a")

        # Extract visible link text
        link_texts = [link.text for link in links if link.text]

        # Basic sanity checks
        assert len(link_texts) > 0
        assert "Form Authentication" in link_texts

def test_link_attributes():
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get("https://the-internet.herokuapp.com/")

        links = driver.find_elements(By.TAG_NAME, "a")

        # Filter links that actually have visible text
        visible_links = [link for link in links if link.text]

        # Verify each visible link has a valid href
        for link in visible_links:
            href = link.get_attribute("href")

            assert href is not None
            assert href.startswith("http")