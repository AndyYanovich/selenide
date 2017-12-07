package selenide.pages.developer;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelectPage extends AbstractPage {

    private SelenideElement search = $(By.name("select"));


    public SelectPage searchFor(String searchText) {
        search.val(searchText).pressEnter();
        return this;
    }

}
