import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Features("Google search")
@Stories({"WEB-888"})
public class GoogleTest extends SelenideTestBase {
    private String google = "http://google.com/ncr";
    private String searchText = "selenide";

    @Test
    public void searchInGoogleTest() {
        open(google);
        $(By.name("q")).val(searchText).pressEnter();
        $$("#ires .g").shouldHave(size(10));
    }

    @Test
    public void searchInGoogleWithPageObjectTest() {
        open(google);
        SearchPage googleSearch = new SearchPage();
        googleSearch.searchFor(searchText);
        SearchResultPage googleResult = new SearchResultPage();
        googleResult.getLinkResults()
                    .shouldHave(size(9))
                    .first()
                    .shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
