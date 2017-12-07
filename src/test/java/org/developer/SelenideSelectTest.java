package org.developer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class SelenideSelectTest extends SelenideTestBase{
    private String searchText = "selenide";
    private SearchPage searchPage = new SearchPage();
    private SearchResultPage searchResultPage = new SearchResultPage();

    private WebElement selElem;
//    private selElem = driver.findElement(By.name("type"));
    Select selectObject = new Select(selElem);


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

    @Test
    public void pageObjectSelectTest(){
        open("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
//        searchPage.()
    }

    private String alertExample = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";
    @Test
    public void alertTest() {
        open(alertExample);
        switchTo().frame("iframeResult");
        $(By.xpath("/html/body/button")).click();
        switchTo().alert().dismiss();
        $(By.id("demo")).shouldHave(text("Press a button!"));

    }

}

