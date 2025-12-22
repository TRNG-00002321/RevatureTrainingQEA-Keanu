package com.revature.sel.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Pom Implementation")
public class TestPOMImpl {
    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setup(){
        // Set up your WebDriverManager
        WebDriverManager.chromedriver().setup();

        // initialize your WebDriver
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(BASE_URL + "/login");
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
    @DisplayName("Test Login Valid")
    void testLoginValid(){
        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = loginPage.loginAs("tomsmith","SuperSecretPassword!");

        assertTrue(securePage.getFlashMessage().contains("logged"));
    }
}
