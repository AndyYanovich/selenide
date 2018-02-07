package com.equerest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillFIO(String firstName, String lastName){
        WebElement fio = webDriver.findElement(By.id("fio"));
        fio.sendKeys(firstName + " " + lastName);
    }

    public void fillCity(String city) {
        WebElement fio = webDriver.findElement(By.id("city"));
        fio.sendKeys(city);
    }
}
