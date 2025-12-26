"""
Behave environment for Selenium tests.
"""
import allure
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import os

def before_feature(context, feature):
    """Add feature to Allure."""
    # Feature-level setup for reporting
    allure.dynamic.feature(feature.name)


def before_scenario(context, scenario):
    """Initialize WebDriver before each scenario."""
    options = Options()

    """Add scenario details to Allure."""
    allure.dynamic.story(scenario.name)

    # Add tags
    for tag in scenario.effective_tags:
        allure.dynamic.tag(tag)

    # Check for headless tag
    if 'headless' in scenario.effective_tags:
        options.add_argument('--headless')

    options.add_argument('--window-size=1920,1080')
    options.add_argument('--no-sandbox')

    service = Service(ChromeDriverManager().install())
    context.driver = webdriver.Chrome(service=service, options=options)
    context.driver.implicitly_wait(10)


def after_scenario(context, scenario):
    """Cleanup after each scenario."""
    if scenario.status == 'failed':
        os.makedirs('screenshots', exist_ok=True)
        context.driver.save_screenshot(
            f"screenshots/{scenario.name.replace(' ', '_')}.png"
        )

    """Attach screenshot and logs on failure."""
    if scenario.status == 'failed':
        # Capture screenshot
        if hasattr(context, 'driver'):
            screenshot = context.driver.get_screenshot_as_png()
            allure.attach(
                screenshot,
                name=f'Failure_{scenario.name}',
                attachment_type=allure.attachment_type.PNG
            )

        # Attach browser logs
        if hasattr(context, 'driver'):
            try:
                logs = context.driver.get_log('browser')
                if logs:
                    log_text = '\n'.join([str(l) for l in logs])
                    allure.attach(
                        log_text,
                        name='Browser Logs',
                        attachment_type=allure.attachment_type.TEXT
                    )
            except Exception:
                pass

    if hasattr(context, 'driver'):
        context.driver.quit()