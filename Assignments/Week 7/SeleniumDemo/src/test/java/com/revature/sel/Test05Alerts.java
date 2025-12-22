package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test05Alerts {
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
    void testAlert1(){
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        assertTrue(alert.getText().contains("I am a JS Alert"));
    }

    @Test
    void testAlertPrompt(){
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert prompt = driver.switchTo().alert();
        assertEquals("I am a JS prompt", prompt.getText());

        // Type response
        prompt.sendKeys("John Doe");

        // Accept
        prompt.accept();

        assertTrue(driver.findElement(By.id("result")).getText().contains("John Doe"));
    }


}
