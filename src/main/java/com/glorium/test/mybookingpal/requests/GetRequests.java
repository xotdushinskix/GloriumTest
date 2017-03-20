package com.glorium.test.mybookingpal.requests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GetRequests {

    public int getLocationId(String city, String country) {
        String url = "https://www.mybookingpal.com/api/location/getinfo?location=";
        String fullURL = url + city + ",%20" + country;

        JSONObject responseBody = getResponseBody(fullURL);

        JSONObject cityData = (JSONObject) responseBody.get("data");
        String cityId = (String) cityData.get("ID");
        return Integer.valueOf(cityId);
    }

    public ArrayList<String> getApartmentsName(String city, String country, String fromDate, String toDate,
                                               int personQuantity, String currency) {

        int requiredId = getLocationId(city, country);
        String fullURL = "https://www.mybookingpal.com/xml/services/json/reservation/products/" + requiredId + "/"
                + fromDate + "/" +  toDate + "?pos=a502d2c65c2f75d3&guests="
                + personQuantity +  "&currency=" + currency;
        JSONObject responseBody = getResponseBody(fullURL);
        JSONArray apartmentsContent = getApartmentsContent(responseBody);
        Iterator i = apartmentsContent.iterator();
        ArrayList<String> apartmentNames = new ArrayList<String>();
        while (i.hasNext()) {
            JSONObject apartment = (JSONObject) i.next();
            String productName = (String)apartment.get("productname");
            apartmentNames.add(productName);
        }

        return apartmentNames;
    }

    public int getApartmentId(String city, String country, String fromDate, String toDate, int personQuantity,
                                               String currency, String apartmentName) {

        int requiredId = getLocationId(city, country);
        String fullURL = "https://www.mybookingpal.com/xml/services/json/reservation/products/" + requiredId + "/" +
                fromDate + "/" +  toDate + "?pos=a502d2c65c2f75d3&guests="
                + personQuantity +  "&currency=" + currency;
        JSONObject responseBody = getResponseBody(fullURL);
        JSONArray apartmentsContent = getApartmentsContent(responseBody);
        int apartmentId = 0;
        for (int w = 0; w < apartmentsContent.size(); w++) {
            JSONObject apartmentInfo = (JSONObject) apartmentsContent.get(w);
            if (apartmentInfo.get("productname").equals(apartmentName)) {
                long id = (Long)apartmentInfo.get("productid");
                apartmentId = (int)id;
            }
        }
        return apartmentId;
    }

    public String[] getPriceAndQuoteByApartmentName(String city, String country, String fromDate, String toDate,
                                                    int personQuantity, String currency, String apartmentName) {

        int apartmentId = getApartmentId(city, country, fromDate, toDate, personQuantity, currency, apartmentName);
        String fullURL = "https://www.mybookingpal.com/xml/services/json/reservation/quotes?pos=a502d2c65c2f75d3&productid="
                + apartmentId + "&fromdate=" + fromDate + "&todate=" +  toDate + "&currency=" + currency +
                "&adults=" + personQuantity;

        JSONObject responseBody = getResponseBody(fullURL);
        JSONObject quotes = (JSONObject) responseBody.get("quotes");
        double quote = (Double) quotes.get("quote");
        double price = (Double) quotes.get("price");
        String quoteStr = String.valueOf(quote);
        String priceStr = String.valueOf(price);
        String[] quoteAndPrice = new String[2];
        quoteAndPrice[0] = quoteStr;
        quoteAndPrice[1] = priceStr;
        return quoteAndPrice;
    }

    public ArrayList<String> getAllApartmentsNames(String city, String country, String fromDate, String toDate,
                                                   int personQuantity, String currency) {
        ArrayList<String> allApartmentsNames = getApartmentsName(city, country, fromDate, toDate,
                personQuantity, currency);
        return allApartmentsNames;
    }

    private JSONObject getResponseBody(String fullURL) {
        JSONParser parser = new JSONParser();
        JSONObject responseBody = null;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(fullURL);

        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpEntity entity = httpResponse.getEntity();
        try {
            responseBody = (JSONObject) parser.parse(EntityUtils.toString(entity, "UTF-8"));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int responseStatus = httpResponse.getStatusLine().getStatusCode();
        assert responseStatus == 200;
        return responseBody;
    }

    private JSONArray getApartmentsContent(JSONObject responseBody) {
        JSONObject searchResponse = (JSONObject) responseBody.get("search_response");
        JSONObject searchQuotes = (JSONObject) searchResponse.get("search_quotes");
        JSONArray apartmentContent = (JSONArray) searchQuotes.get("quote");
        return apartmentContent;
    }

}
