package com.revature.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@DisplayName("Tracing Demo")
public class TestPW04_Tracing {

    @Test
    @DisplayName("Basic Tracing")
    public void testBasicDemo() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            //start tracing before you perform a test
            context.tracing().start(
                    new Tracing.StartOptions()
                            .setScreenshots(true)
                            .setSnapshots(true)
                            .setSources(true)
            );

            System.out.println("Tracing started...");

            Page page = context.newPage();

            page.navigate("https://the-internet.herokuapp.com/login");

            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator("button[type='submit']").click();

            page.waitForURL("**/secure");

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/traces/trace-login.zip"))
            );

            context.close();
            browser.close();
        }
    }

    @DisplayName("Advance Tracing")
    @Test
    public void demoAdvancedTracing() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            // Start with title for organization
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true)
                    .setTitle("Login Flow Test")  // Shows in Trace Viewer
            );
            System.out.println("   ✓ Tracing started with title");

            Page page = context.newPage();

            // Test scenario 1
            page.navigate("https://the-internet.herokuapp.com/");
            System.out.println("   → Test scenario 1: Homepage");

            // Create a checkpoint (chunk) in the trace
            context.tracing().startChunk();

            page.locator("a:has-text('Form Authentication')").click();
            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            page.locator("button[type='submit']").click();

            // Save this chunk separately
            context.tracing().stopChunk(new Tracing.StopChunkOptions()
                    .setPath(Paths.get("target/traces/trace-login.zip"))
            );
            System.out.println("   ✓ Login chunk saved: trace-login.zip");

            // Test scenario 2
            context.tracing().startChunk();

            page.locator("a[href='/logout']").click();
            page.waitForURL("**/login");

            context.tracing().stopChunk(new Tracing.StopChunkOptions()
                    .setPath(Paths.get("target/traces/trace-logout.zip"))
            );
            System.out.println("   ✓ Logout chunk saved: trace-logout.zip");

            // Final cleanup
            context.tracing().stop();
            context.close();
            browser.close();
        }

        System.out.println();
    }
}
