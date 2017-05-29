package com.glorium.test.olx;

import org.junit.Test;

public class CreateNewAdvertisementTest extends AbstractHelpAdvertisementTest {

	@Test
	public void testCreateNewAdvertisement() {
		olxMainPage
				.postNewAdvertisement()
				.openRubrics()
				.openPetsChapter()
				.selectCatsSection()
				.fillTitle("Selling a cat")
				.fillPrice(100)
				.selectPersianBreed()
				.selectPrivateAuthorType()
				.fillDescription("hello world, hello world, hello world")
				.clickOnFurtherButton()
				.cancelPayment()
				.checkThatYourAdvertisementHasAccepted();
	}

}
