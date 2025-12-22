package com.revature.sel.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage enterUsername(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(name);

        return this;
    }

    public LoginPage enterPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);

        return this;
    }

    public SecurePage clickLogin(){
        driver.findElement(loginButton).click();

        return new SecurePage(driver);
    }

    public LoginPage clickLoginExceptionError(){
        driver.findElement(loginButton).click();

        return this;
    }

    public SecurePage loginAs(String username, String password){
        return enterUsername(username).enterPassword(password).clickLogin();
    }

}
