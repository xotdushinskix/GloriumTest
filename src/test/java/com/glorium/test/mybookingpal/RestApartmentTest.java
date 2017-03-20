package com.glorium.test.mybookingpal;

import com.glorium.test.mybookingpal.requests.GetRequests;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class RestApartmentTest {

    private static GetRequests getRequests;

    @BeforeClass
    public static void beforeClass() {
        getRequests = new GetRequests();
    }

    @Test
    public void testThatRequiredApartmentIsAvailable() {
        ArrayList<String> allApartmentsNames = getRequests.getAllApartmentsNames("Paris", "France",
                "2017-04-17", "2017-04-24", 2, "USD");
        Assert.assertTrue(allApartmentsNames.contains("Apartment Geoffroy Saint Hilaire"));
    }

    @Test
    public void testApartmentPriceAndQuote() {
        String[] quoteAndPrice = getRequests.getPriceAndQuoteByApartmentName("Paris", "France", "2017-04-17",
                "2017-04-24", 2, "USD", "Apartment Geoffroy Saint Hilaire");
        String quote = quoteAndPrice[0];
        String price = quoteAndPrice[1];
        Assert.assertNotEquals(price.length(), 0);
        Assert.assertNotEquals(quote.length(), 0);
        Assert.assertEquals(quote, price);
    }

}
