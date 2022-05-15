package gmail.asteroster;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchRepositoryTest {
    @BeforeAll
    static void  setBrowser () {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void  shouldFindSelenideAsFirstRepository() {

        //открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]")
                .setValue("selenide")
                .pressEnter();
        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list").first().$("a").click();
        // check: в заголовке встречается selenide/selenide
        $("h2").shouldHave(Condition.text("selenide / selenide"));
    }

}
