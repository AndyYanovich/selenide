package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import selenium.core.WebDriverTestBase;

import static org.testng.AssertJUnit.assertTrue;


@Features("Google search")
@Stories({"WEB-777"})
public class GoogleSearchTest extends WebDriverTestBase {

    private String googleSearch = "https://www.google.com.ua/";
    private String searchText = "Selenium";

    @Title("Searches for text on Google")
    @Test
    public void searchTest() {
        webDriver.get(googleSearch);
        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));
    }
}
