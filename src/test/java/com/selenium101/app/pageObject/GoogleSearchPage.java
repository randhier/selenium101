package com.selenium101.app.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {

    private static By searchElement = By.id("lst-ib");
    private static By searchButtonElement = By.cssSelector(".sbico svg");
    private static By resultStringElement = By.cssSelector(".vk_gy.vk_sh.whenis span:nth-of-type(2)");

    public GoogleSearchPage(WebDriver driver){
        super(driver);

    }

    public String returnResult () {

        return returnText(resultStringElement);

    }

    public void search(String searchTerm) {
        WebElement element = driver.findElement(searchElement);
        element.clear();
        element.sendKeys(searchTerm);
        highlight(searchButtonElement);
        driver.findElement(searchButtonElement).click();
        element.sendKeys(Keys.RETURN);
    }




}
