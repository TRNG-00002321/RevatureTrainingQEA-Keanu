package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test04Waits {
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

    @Test
    @DisplayName("Without Waits")
    void withoutWait(){
        driver.get(BASE_URL + "/dynamic_loading/1");

        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
        //button.click();

        WebElement result = driver.findElement(By.id(("finish")));
        assertEquals("Hello World!", result.getText());
    }

    @Test
    @DisplayName("Test Implicit Waits")
    void testImplicitWaits(){
        //Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get(BASE_URL + "/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
        button.click();

        WebElement result = driver.findElement(By.xpath(("//h4[normalize-space()='Hello World!']")));
        assertTrue(result.getText().contains("Hello"));
    }

    @Test
    @DisplayName("Test Explicit Wait")
    void testExplicitWait(){

        driver.get(BASE_URL + "/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
        button.click();

        //Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        assertTrue(result.getText().contains("Hello"));
    }

    @Test
    @DisplayName("Fluent Waits")
    void testFluentWaits(){
        driver.get(BASE_URL + "/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
        button.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500)) //checks whether the expected condition is satisfied
                .ignoring(NoSuchElementException.class)
                .withMessage("Waiting for the result");

        WebElement result = fluentWait.until(driver->{
            WebElement element = driver.findElement(By.id("finish"));
            return element.isDisplayed()?element:null;
        });

        assertTrue(result.getText().contains("Hello"));
    }
}
