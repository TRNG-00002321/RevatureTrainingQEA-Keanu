package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Basic Selenium Tests")
public class Test01SelBasics {

    private WebDriver driver;

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
    public void TestBasic() throws InterruptedException {

        // Navigate to website
        driver.get("https://www.selenium.dev/");
        Thread.sleep(5000);

        // Get the page Title
        String title = driver.getTitle();
        System.out.println("Title :: " + title);

        assertTrue(title.contains("Selenium"));
    }

    @Test
    public void TestBasic2() throws InterruptedException {

        // Navigate to website
        driver.get("https://www.selenium.dev/documentation/");
        Thread.sleep(5000);

        // Get the page Title
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL :: " + currentUrl);

        assertTrue(currentUrl.contains("documentation"));
    }
}
