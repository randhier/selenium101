package com.selenium101.app;

import com.selenium101.app.pageObject.GoogleSearchPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SettingsTest {
    private static WebDriver driver;
    private GoogleSearchPage GooglePage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/chromedriverMAC");
        driver = new ChromeDriver();
    }

    @Before
    public void setup() {
        GooglePage = new GoogleSearchPage(driver);
        driver.get("http://google.com");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Rule
    public ScreenTest image = new ScreenTest(driver);

    @org.junit.Test
    public void settingsTest() throws InterruptedException {
        GooglePage.clickSettings();
    }

}
