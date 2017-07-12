package com.selenium101.app.pageObject;

import org.openqa.selenium.*;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void highlight(By selector) {
        WebElement styleElement = driver.findElement(selector);
        executor(styleElement,"border: 2px solid red; border-style: dashed;");
    }

    public void highlight(By selector, int timer) {
        WebElement styleElement = driver.findElement(selector);
        String originalStyle = styleElement.getAttribute("style");
        highlight(selector);
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor(styleElement, originalStyle);
    }

    private void executor(WebElement element, String style){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                style);
    }

    public String returnText(By selector) {
        return driver.findElement(selector).getText();
    }


}
