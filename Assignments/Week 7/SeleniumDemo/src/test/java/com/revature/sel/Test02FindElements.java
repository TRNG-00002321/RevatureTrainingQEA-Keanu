package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Finding Elements")
public class Test02FindElements {
    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setup(){
        // Set up your WebDriverManager
        WebDriverManager.chromedriver().setup();

        // initialize your WebDriver
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            //Closes all windows and ends session
            driver.quit();

            //Closes current window
            //driver.close();
        }
    }

    @DisplayName("Test By Id")
    @Test
    public void testById(){
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));

        assertTrue(userName.isDisplayed());
        assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Name")
    @Test
    public void testByName(){
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.name("username"));
        WebElement pass = driver.findElement(By.name("password"));

        assertTrue(userName.isDisplayed());
        assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By TagName")
    @Test
    public void testByTagName(){
        driver.get(BASE_URL + "/login");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        for(WebElement i : inputs){
            assertTrue(i.isDisplayed());
        }

        System.out.println(inputs.toArray().length);
    }

    @DisplayName("Test By Class")
    @Test
    public void testByClass(){
        driver.get(BASE_URL + "/login");
        WebElement button = driver.findElement(By.className("radius"));

        assertEquals("Login", button.getText());
    }

    @DisplayName("Test By AbsXPath")
    @Test
    public void testByAbsXPath(){
        driver.get(BASE_URL);
        String absPath = "/html[1]/body[1]/div[2]/div[1]/h2[1]";
        WebElement text = driver.findElement(By.xpath(absPath));

        assertEquals("Available Examples", text.getText());
    }

    @DisplayName("Test By XPath Both")
    @Test
    public void testByXPath() throws InterruptedException {
        driver.get(BASE_URL + "/login");
        String absPath = "/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]";
        String relativePath = "//input[@id='password']";

        WebElement username = driver.findElement(By.xpath(absPath));
        WebElement password = driver.findElement(By.xpath(relativePath));

        username.sendKeys("Hello");

        Thread.sleep(5000);

        assertTrue(username.isDisplayed());
        assertTrue(password.isDisplayed());
    }

    @DisplayName("Test Login Flow")
    @Test
    public void testLoginFlow() throws InterruptedException {
        driver.get(BASE_URL + "/login");
        String usernamePath = "//input[@id='username']";
        String passwordPath = "//input[@id='password']";
        String buttonPath = "//i[@class='fa fa-2x fa-sign-in']";

        // Find elements
        WebElement username = driver.findElement(By.xpath(usernamePath));
        WebElement password = driver.findElement(By.xpath(passwordPath));
        WebElement button = driver.findElement(By.xpath(buttonPath));

        //Verify elements are displayed and enabled
        if(username.isDisplayed() && password.isDisplayed()){
            if(username.isEnabled() && password.isEnabled()){

                // Clear and enter credentials
                username.clear();
                password.clear();

                username.sendKeys("tomsmith");
                password.sendKeys("SuperSecretPassword!");

                // Verify input values
                assertEquals("tomsmith", username.getAttribute("value"));
                assertEquals("SuperSecretPassword!", password.getAttribute("value"));

                // Click login
                button.click();

                // Verify success
                WebElement flashText = driver.findElement(By.xpath("//div[@id='flash']"));

                assertTrue(flashText.getText().contains("You logged into a secure area!") ||
                        driver.getCurrentUrl().contains("secure"));
            }
        }

        Thread.sleep(5000);
    }
}
