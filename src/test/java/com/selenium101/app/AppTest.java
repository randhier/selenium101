package com.selenium101.app;

import com.selenium101.app.pageObject.GooglePage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    private static WebDriver driver;
    private GooglePage GooglePage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/chromedriverMAC");
        driver = new ChromeDriver();
    }

    @Before
    public void setup() {
        GooglePage = new GooglePage(driver);
        driver.get("http://google.com");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Rule
    public ScreenTest image = new ScreenTest(driver);

    @org.junit.Test
    public void motherDayTest() throws InterruptedException {
        GooglePage.search("mother's day");
        Thread.sleep(4000);
        assertEquals("Mother's Day 2018 in United States of America", GooglePage.returnResult());

    }

}
