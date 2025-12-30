package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("PW Screenshots and Video Demo")
public class TestPW03_SS_Videos {

    @Test
    @DisplayName("Screenshot Demo")
    public void testScreenshot(){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/basic.png"))
                    .setFullPage(true)
            );

            // Screenshot of specific element
            page.locator("//a[@class='getStarted_Sjon']").screenshot(new Locator.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/header.png"))
            );

            browser.close();
        }
    }

    @Test
    @DisplayName("PW Test Video Demo")
    public void testVideo(){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch();

            // Enable video recording in context
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("target/videos/"))
                    .setRecordVideoSize(1280, 720)
            );

            Page page = context.newPage();
            System.out.println("Recording Started...");

            page.navigate("https://the-internet.herokuapp.com/login");

            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator("button[type='submit']").click();

            assertThat(page.locator("#flash")).containsText("secure area");

            context.close();
            browser.close();
        }
    }
}
