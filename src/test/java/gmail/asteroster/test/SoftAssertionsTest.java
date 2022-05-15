package gmail.asteroster.test;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsTest {
    @BeforeAll
  static void setBrowser () {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @DisplayName("Проверка на странице SoftAssertions")
    @Test
    void shouldFindSoftAssertionsPage () {
        //открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]")
                .setValue("selenide")
                .pressEnter();
        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body")
                .shouldHave(text("static SoftAssertsExtension softAsserts = new SoftAssertsExtension();"));
    }
}
