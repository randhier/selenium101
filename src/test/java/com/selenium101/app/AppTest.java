package com.selenium101.app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest
{
    private static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception{
        System.setProperty("webdriver.chrome.driver", "./src/test/java/chromedriverMAC");
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Rule
    public ScreenTest image = new ScreenTest(driver);

    @org.junit.Test
    public void testApp() throws InterruptedException
    {
        assertTrue(true);
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.clear();
        element.sendKeys("mother's day");
        driver.findElement(By.cssSelector(".sbico svg")).click();
        element.sendKeys(Keys.RETURN);
        Thread.sleep(4000);
        assertEquals("Mother's Day 2017 in United States of America", driver.findElement(By.cssSelector(".vk_gy.vk_sh.whenis span:nth-of-type(2)")).getText());
    }
}
