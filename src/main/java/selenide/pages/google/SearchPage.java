package selenide.pages.google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends AbstractPage {

    private SelenideElement search = $(By.name("q"));

    public SearchPage searchFor(String searchText) {
        search.val(searchText).pressEnter();
        return this;
    }
}
