package com.glorium.test.olx.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

	protected static FirefoxDriver driver;

	protected static WebDriver getWebDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.olx.ua/");
		}
		return driver;
	}

}
