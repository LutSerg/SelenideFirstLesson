package gmail.asteroster;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class ContributersTest {
    @BeforeAll
    static void  setBrowser () {
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void showFirstContributor () {
        Configuration.browserSize = "1200x400";
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(byText("Contributors")).ancestor("div")
                .$$("ul li").first().hover();
        $$(".Popover-message").findBy(Condition.visible)
                .shouldHave(Condition.text("Andrei Solntsev"));
    }
}
