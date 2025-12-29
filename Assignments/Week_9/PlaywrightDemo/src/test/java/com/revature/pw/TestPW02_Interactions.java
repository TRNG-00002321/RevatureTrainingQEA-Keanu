package com.revature.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Playwright Element Locate and Interactions")
public class TestPW02_Interactions extends BaseTest{

    @DisplayName("Playwright Interactions")
    @Test
    public void demoWaits(){
        navigateTo("/dynamic_loading/1");

        page.locator("#start button").click();
        String test = page.locator("#finish h4").textContent();

        System.out.println("Result :: " + test);
    }

    @DisplayName("Playwright Locators")
    @Test
    public void demoLocators(){
        navigateTo("/login");

        Locator byId = page.locator("#username");

        Locator byText = page.locator("text=login");

        Locator byRole = page.getByRole(AriaRole.BUTTON);

        Locator byLabel = page.getByLabel("username");
    }

    @Test
    @DisplayName("Element Interactions")
    public void demoInteractions(){
        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();

        assertThat(page.locator("#flash")).containsText("secure area");
    }
}
