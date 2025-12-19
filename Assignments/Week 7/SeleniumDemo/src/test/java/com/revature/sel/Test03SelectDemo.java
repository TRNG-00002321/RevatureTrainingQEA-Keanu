package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test03SelectDemo {
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
    @DisplayName("Testing Select List")
    public void testSelectDemo(){
        driver.get(BASE_URL + "/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        Select dropDown = new Select(dropdownElement);

        dropDown.selectByVisibleText("Option 1");
        //dropDown.selectByValue("1");

        WebElement selectedOption = dropDown.getFirstSelectedOption();

        assertEquals("Option 1", selectedOption.getText());
    }

    @Test
    @DisplayName("Action API in Action...")
    public void actionAPIDemo() throws InterruptedException {
        driver.get(BASE_URL + "/login");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        Actions actions  = new Actions(driver);

        actions.click(userName)
                .sendKeys("tomsmith")
                .sendKeys(Keys.TAB)
                .sendKeys("SuperSecretPassword!")
                .click(button)
                .perform();

        Thread.sleep(3000);
    }
}
