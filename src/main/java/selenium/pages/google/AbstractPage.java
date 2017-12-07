package selenium.pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(this.webDriver, 10);
    }

    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {
        return webDriverWait.until(expectedCondition);
    }

    public void jsClick(String locator, String type) {
        switch (type) {
            case "id":
                executeJavaScript("document.getElementById(\"" + locator + "\").click()");
                break;
            case "name":
                executeJavaScript("document.getElementsByName(\"" + locator + "\")[0].click()");
                break;
        }
    }
}
