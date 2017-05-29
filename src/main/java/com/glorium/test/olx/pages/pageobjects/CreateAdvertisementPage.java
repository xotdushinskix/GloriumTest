package com.glorium.test.olx.pages.pageobjects;

import com.glorium.test.olx.pages.AbstractHelpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateAdvertisementPage extends AbstractHelpPage {

	private WebDriver driver;

	public static final String TITLE_FIELD = "#add-title";
	public static final String RUBRIC_DD = "#targetrenderSelect1-0 a";
	public static final String RUBRIC_CLOSE_BUTTON = "#fancybox-close";
	public static final String CATS_RUBRIC = "#category-35 li:nth-child(3)";
	public static final String PRICE_INPUT = ".marginbott5.lheight24.clr input:nth-child(2)";
	public static final String BREED_DROPDOWN = "#targetparam153";
	public static final String PERSIAN_BREED = "#targetparam153 li:nth-child(19)";
	public static final String AUTHOR_TYPE = "#targetid_private_business dt";
	public static final String PRIVATE_PERSON = "#targetid_private_business li:nth-child(2)";
	public static final String DESCRIPTION_PART = "#add-description";
	public static final String PETS_CHAPTER = "#cat-35";
	public static final String FURTHER_BUTTON = "#save";

	public CreateAdvertisementPage(FirefoxDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public CreateAdvertisementPage fillTitle(String title) {
		waitUntilElemWillBePresent(TITLE_FIELD).sendKeys(title);
		return this;
	}

	public CreateAdvertisementPage openRubrics() {
		waitUntilElemWillBePresent(RUBRIC_DD).click();
		return this;
	}

	public CreateAdvertisementPage openPetsChapter() {;
		waitUntilElemWillBePresent(PETS_CHAPTER).click();
		return this;
	}

	public CreateAdvertisementPage selectCatsSection() {
		waitUntilElemWillBePresent(RUBRIC_CLOSE_BUTTON);
		getElement(CATS_RUBRIC).click();
		return this;
	}

	public CreateAdvertisementPage fillPrice(int price) {
		getElement(PRICE_INPUT).sendKeys(String.valueOf(price));
		return this;
	}

	public CreateAdvertisementPage selectPersianBreed() {
		getElement(BREED_DROPDOWN).click();
		getElement(PERSIAN_BREED).click();
		return this;
	}

	public CreateAdvertisementPage fillDescription(String description) {
		getElement(DESCRIPTION_PART).sendKeys(description);
		return this;
	}

	public CreateAdvertisementPage selectPrivateAuthorType() {
		getElement(AUTHOR_TYPE).click();
		getElement(PRIVATE_PERSON).click();
		return this;
	}

	public PaymentPage clickOnFurtherButton() {
		getElement(FURTHER_BUTTON).click();
		return new PaymentPage((FirefoxDriver)driver);
	}

}

