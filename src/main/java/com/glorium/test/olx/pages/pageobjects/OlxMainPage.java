package com.glorium.test.olx.pages.pageobjects;

import com.glorium.test.olx.pages.AbstractHelpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OlxMainPage extends AbstractHelpPage {

	protected WebDriver driver;

	public static final String POST_NEW_ADVERTISEMENT = "#postNewAdLink";
	public static final String MY_PROFILE = "#topLoginLink span";
	public static final String LOG_OUT = ".last span:nth-child(2)";

	public OlxMainPage(FirefoxDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return new LoginPage((FirefoxDriver)driver);
	}

	public OlxMainPage postNewAdvertisement() {
		waitUntilElemWillBePresent(POST_NEW_ADVERTISEMENT).click();
		return this;
	}

	public OlxMainPage openMyProfile() {
		waitUntilElemWillBePresent(MY_PROFILE).click();
		return this;
	}

	public OlxMainPage logOut() {
		new Actions(driver).moveToElement(getElement(MY_PROFILE)).build().perform();
		getElement(LOG_OUT).click();
		return this;
	}

}
