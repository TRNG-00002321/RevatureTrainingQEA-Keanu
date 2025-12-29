package com.revature.pw;

import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTest {

    @Test
    void shouldLoginSuccessfully() {
        navigateTo("/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("//button[@type='submit']").click();

        assertThat(page).hasURL(Pattern.compile(".*secure"));
    }

    @Test
    void shouldShowErrorForInvalidCredentials() {
        navigateTo("/login");

        page.locator("#username").fill("invalid");
        page.locator("#password").fill("wrong");
        page.locator("//button[@type='submit']").click();

        assertThat(page.locator("//div[@id='flash']")).isVisible();
    }
}