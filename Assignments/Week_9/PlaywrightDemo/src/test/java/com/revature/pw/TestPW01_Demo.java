package com.revature.pw;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@DisplayName("Playwright Demo")
public class TestPW01_Demo {

    @Test
    @DisplayName("Playwright Test")
    public void basicTest(){

        //Playwright.create() initializes the Playwright library
        try(Playwright playwright = Playwright.create()){

            //Launch the browser
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(true) //Default headless = true
                            .setSlowMo(500)     //Slowdown for visibility
            );

            //Create a new page (tab)
            Page page = browser.newPage();

            //navigate to a url
            page.navigate("https://playwright.dev");

            //Get and print title
            String title = page.title();
            System.out.println("Title:: " + title);
            System.out.println("URL:: " + page.url());

            //Auto-waiting Locator
            page.locator("text = Get started").click();

            //Auto-retrying assertion
            assertThat(page).hasURL(Pattern.compile(".*intro"));
            System.out.println("Navigated to :: " + page.url());
        }
    }
}
