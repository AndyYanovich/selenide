package com.google;

import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.SearchPage;

public class SeleniumGoogleSearchPage extends WebDriverTestBase{

    private String selenium = "Selenium";
    private SearchPage searchPage = new SearchPage(webDriver);

    @Test
    public void search() {
        webDriver.get("https://google.com.ua/");
        searchPage.searchFor(selenium);
    }
}
