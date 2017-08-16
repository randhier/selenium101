package com.selenium101.app.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {

    private static By searchElement = By.id("lst-ib");
    private static By searchButtonElement = By.cssSelector(".sbico svg");
    private static By resultStringElement = By.cssSelector(".vk_gy.vk_sh.whenis span:nth-of-type(2)");
    private static By settingsElement = By.id("fsettl");
    private static By searchSetting = By.linkText("Search settings");
    private static By languageLink = By.linkText("Languages");
    private static By dutch = By.cssSelector(".jfk-radiobutton-radio");

    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }

    public String returnResult () {
        return returnText(resultStringElement);
    }
    public void clickLanguageLink () {
        clickElement(languageLink);
    }

    public void search(String searchTerm) {
        WebElement element = driver.findElement(searchElement);
        element.clear();
        element.sendKeys(searchTerm);
        highlight(searchButtonElement);
        driver.findElement(searchButtonElement).click();
        element.sendKeys(Keys.RETURN);
    }


    public void clickSettings() {
        clickElement(settingsElement);
        clickElement(searchSetting);
    }

    public void clickDutch() {
        clickElement(dutch);
    }
}
