package com.google;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideGoogleSearchTest extends SelenideTestBase{
    private String searchText = "selenide";
    private SearchPage searchPage = new SearchPage();
    private SearchResultPage searchResultPage = new SearchResultPage();


    //TODO https://tc-jira.atlassian.net/browse/WEB-44057
    @Test(enabled = false)
    public void searchTest(){
        open("https://www.google.com.ua");
        $(By.name("q")).val(searchText).submit();
        $(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a")).should(visible,text(searchText));
    }

    @Test
    public void pageObjectSearchTest(){
        open("http://google.com/ncr");
        searchPage.searchFor(searchText);
        searchResultPage.getLinkResults()
                        .shouldHaveSize(9)
                        .first()
                        .should(text("Selenide: concise UI tests in Java"));
    }
}
