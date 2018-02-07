package com.equerest.steps;

import com.equerest.pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterpreneurSteps {

    public static final String REGISTER_PAGE = "https://dev.equerest.com/register#/entrepreneur";

    private WebDriver webDriver;

    @Given("^I am on new project registration page$")
    public void openRegisterPage() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.get(REGISTER_PAGE);
    }



    @When("^I fill my first name \"([^\"]*)\" and last name \"([^\"]*)\"")
    public void fillFirstAndLastName(String firstName, String lastName){
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.fillFIO(firstName, lastName);
    }

    @And("I fill my City \"([^\"]*)\"")
    public void fillCity(String city) {
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.fillCity(city);
    }
}
