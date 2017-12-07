package selenium.pages.google;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    private By searchLocator = By.xpath(".//*[@id='rso']/div/div/div/div/div/h3/a");
    private WebElement search;
    private ElementsCollection linkResult;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

//    public List<WebElement> getLinkResults () {
//        linkResult = webDriver.findElements(searchLocator);
//    }

    //    private ElementsCollection linkResults = $$(By.xpath(".//*[@id='rso']/div/div/div/div/div/h3/a"));

//    public ElementsCollection getLinkResults() {
//        return linkResults;
//    }



}
