package com.glorium.test.olx.pages.pageobjects;

import com.glorium.test.olx.pages.AbstractHelpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage extends AbstractHelpPage {

	private WebDriver driver;

	public final static String LOGIN_FIELD = "#userEmail";
	public final static String PASSWORD_FIELD = "#userPass";
	public final static String LOGIN_BUTTON = "#se_userLogin";

	public LoginPage(FirefoxDriver driver) {
		super(driver);
	}

	public LoginPage logIn(String login, String password) {
		waitUntilElemWillBePresent(LOGIN_FIELD).sendKeys(login);
		getElement(PASSWORD_FIELD).sendKeys(password);
		getElement(LOGIN_BUTTON).click();
		return this;
	}

}
