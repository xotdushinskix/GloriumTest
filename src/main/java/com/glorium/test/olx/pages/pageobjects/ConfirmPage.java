package com.glorium.test.olx.pages.pageobjects;

import com.glorium.test.olx.pages.AbstractHelpPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmPage extends AbstractHelpPage {

    private WebDriver driver;

    public final static String YOUR_ADVERTISEMENT_ACCEPTED = ".clr.margintop10.info.successbox.tcenter.br3 p";

    public ConfirmPage(FirefoxDriver driver) {
        super(driver);
    }

    private String getTextFromYourAdvertisementAcceptedSection() {
        return getElement(YOUR_ADVERTISEMENT_ACCEPTED).getText();
    }

    public ConfirmPage checkThatYourAdvertisementHasAccepted() {
        waitUntilElemWillBePresent(YOUR_ADVERTISEMENT_ACCEPTED);
        Assert.assertEquals(getTextFromYourAdvertisementAcceptedSection(), "Ваше объявление принято");
        return this;
    }

}
