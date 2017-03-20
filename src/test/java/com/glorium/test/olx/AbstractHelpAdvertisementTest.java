package com.glorium.test.olx;

import com.glorium.test.olx.pages.pageobjects.ConfirmPage;
import com.glorium.test.olx.pages.pageobjects.PaymentPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.glorium.test.olx.pages.pageobjects.CreateAdvertisementPage;
import com.glorium.test.olx.pages.pageobjects.OlxMainPage;
import com.glorium.test.olx.util.WebDriverUtil;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractHelpAdvertisementTest extends WebDriverUtil {

	protected static OlxMainPage olxMainPage;
	protected static CreateAdvertisementPage createAdvertisementPage;
	protected static ConfirmPage confirmPage;
	protected static PaymentPage paymentPage;

	@BeforeClass
	public static void before() {
		olxMainPage = new OlxMainPage((FirefoxDriver) getWebDriver());
		createAdvertisementPage = new CreateAdvertisementPage((FirefoxDriver) getWebDriver());
		confirmPage = new ConfirmPage((FirefoxDriver) getWebDriver());
		paymentPage = new PaymentPage((FirefoxDriver) getWebDriver());
		logInBeforeCreateAdvertisement();
	}

	private static void logInBeforeCreateAdvertisement() {
		olxMainPage.openMyProfile().getLoginPage().logIn("@gmail.com", "pass");
	}

	@AfterClass
	public static void tearDown() {
		olxMainPage.logOut();
		getWebDriver().close();
	}

}
