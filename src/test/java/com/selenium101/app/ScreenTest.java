package com.selenium101.app;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenTest extends TestWatcher {

    private WebDriver driver;

    public ScreenTest(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        File fileName = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fileName, new File("src/test/java/failedScreenCaps/" +description.getClassName()+"." + System.currentTimeMillis() + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
