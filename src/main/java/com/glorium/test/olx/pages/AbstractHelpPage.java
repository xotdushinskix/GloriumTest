package com.glorium.test.olx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractHelpPage {

    private WebDriver driver;

    public AbstractHelpPage(FirefoxDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitUntilElemWillBePresent(String element) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
    }

    protected WebElement getElement(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

}
