package com.glorium.test.olx;

import org.junit.Test;

public class CreateNewAdvertisementTest extends AbstractHelpAdvertisementTest {

	@Test
	public void testCreateNewAdvertisement() {
		olxMainPage
				.postNewAdvertisement();
		createAdvertisementPage
				.openRubrics()
				.openPetsChapter()
				.selectCatsSection()
				.fillTitle("Selling a cat")
				.fillPrice(100)
				.selectPersianBreed()
				.selectPrivateAuthorType()
				.fillDescription("by a cat, by a cat, by a cat, by a cat")
				.clickOnFurtherButton();
		paymentPage
				.cancelPayment();
		confirmPage
				.checkThatYourAdvertisementHasAccepted();
	}

}
