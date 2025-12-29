package com.revature.pw;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class PWCodegenLoginTest {

    @Test
    public void LoginTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://the-internet.herokuapp.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("tomsmith");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("SuperSecretPassword!");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login")).click();
            assertThat(page.getByText("You logged into a secure area")).isVisible();
            context.close();
        }
    }

    @Test
    public void LoginTestFail(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("invalid");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("wrong");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login")).click();
            assertThat(page.getByText("Your username is invalid! ×")).isVisible();
            context.close();
        }
    }
}