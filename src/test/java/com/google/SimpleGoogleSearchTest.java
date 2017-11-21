package com.google;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SimpleGoogleSearchTest {

    private WebDriver webDriver;
    private String searchText = "Selenium";

    @BeforeClass
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com.ua");
    }

    @Test
    public void searchTest(){
        By searchFieldLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By resultLinkLocator = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a");
        WebElement resultLink = webDriver.findElement(resultLinkLocator);
        assertTrue(resultLink.getText().contains(searchText));
    }

    @AfterClass
    public void tearDown(){
//        webDriver.close();
        webDriver.quit();
    }
}
