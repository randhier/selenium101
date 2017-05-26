/**
 * Created by plaskai on 5/25/17.
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


    public class Screenshot {
        WebDriver driver;

        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver", "./src/test/java/chromedriverMAC");
            driver = new ChromeDriver();
        }
        @Rule
        public TestRule watcher = new TestWatcher() {
            @Override
            protected void failed(Throwable throwable, Description description) {
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(scrFile,
                            new File("failshot_"
                                    + description.getClassName()
                                    + "_" + description.getMethodName()
                                    + ".png"));
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

            @Override
            protected void finished(Description description) {
                driver.quit();
            }
        };
        @Test
        public void OnError() {
            driver.get("http://google.com");
            assertTrue(true);
            WebElement element = driver.findElement(By.id("lst-ib"));
            element.clear();
            element.sendKeys("mother's day");
            driver.findElement(By.cssSelector(".sbico svg")).click();
            element.sendKeys(Keys.RETURN);
            assertEquals("Mother's Day 2017 in United States of America1", driver.findElement(By.cssSelector(".vk_gy.vk_sh.whenis span:nth-of-type(2)")).getText());
        }




    }
