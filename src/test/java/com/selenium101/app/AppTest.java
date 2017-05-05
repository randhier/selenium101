package com.selenium101.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/chromedriverMAC");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        assertTrue( true );
        Thread.sleep(5000);
        driver.quit();
    }
}
