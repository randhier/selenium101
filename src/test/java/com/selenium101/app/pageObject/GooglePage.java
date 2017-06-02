package com.selenium101.app.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        driver.findElement(searchButtonElement).click();
        element.sendKeys(Keys.RETURN);
    }

    public String returnString() {

        return driver.findElement(resultStringElement).getText();

    }



}
