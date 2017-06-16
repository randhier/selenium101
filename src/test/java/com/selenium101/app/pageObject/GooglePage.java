package com.selenium101.app.pageObject;

import org.openqa.selenium.*;

public class GooglePage {

    private WebDriver driver;

    private static By searchElement = By.id("lst-ib");
    private static By searchButtonElement = By.cssSelector(".sbico svg");
    private static By resultStringElement = By.cssSelector(".vk_gy.vk_sh.whenis span:nth-of-type(2)");


    public GooglePage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String searchTerm) {
        WebElement element = driver.findElement(searchElement);
        element.clear();
        element.sendKeys(searchTerm);
        highlight(searchButtonElement);
        driver.findElement(searchButtonElement).click();
        element.sendKeys(Keys.RETURN);
    }

    public String returnResult() {
        return driver.findElement(resultStringElement).getText();
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
}
