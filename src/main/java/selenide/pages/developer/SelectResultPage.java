package selenide.pages.developer;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SelectResultPage extends AbstractPage {

    private ElementsCollection linkResults = $$(By.xpath(".//*[@id='rso']/div/div/div/div/div/h3/a"));
    
    public ElementsCollection getLinkResults() {
        return linkResults;
    }
}
