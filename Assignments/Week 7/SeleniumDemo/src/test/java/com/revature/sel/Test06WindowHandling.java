package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test06WindowHandling {
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
    void windowTest(){
        driver.get(BASE_URL + "/windows");

        // Store original window handle
        String originalWindow = driver.getWindowHandle();

        // Click link that opens new window
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        // Wait for new window
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Now in new window - perform actions
        assertTrue(driver.getCurrentUrl().contains("new"));

        // Close new window
        driver.close();

        // Switch back to original
        driver.switchTo().window(originalWindow);

        // Verify we're back
        assertTrue(driver.getCurrentUrl().contains("windows"));
    }
}
