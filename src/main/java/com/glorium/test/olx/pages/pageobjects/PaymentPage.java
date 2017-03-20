package com.glorium.test.olx.pages.pageobjects;

import com.glorium.test.olx.pages.AbstractHelpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PaymentPage extends AbstractHelpPage {

    private WebDriver driver;

    public static final String CANCEL_PAYMENT = "#payment_back";

    public PaymentPage(FirefoxDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public PaymentPage cancelPayment() {
        waitUntilElemWillBePresent(CANCEL_PAYMENT).click();
        return this;
    }

}
