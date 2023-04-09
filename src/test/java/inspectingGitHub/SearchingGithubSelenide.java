package inspectingGitHub;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchingGithubSelenide {

    @Test
    void searchingSelenideJUnit5() {
        //Configuration.holdBrowserOpen = true;

//Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

//Перейти в раздел Wiki проекта
        $("a#wiki-tab").click();

//В списке страниц (Pages) есть страница SoftAssertions
        $("div#wiki-pages-box input#wiki-pages-filter").setValue("soft");
        $("div#wiki-pages-box ul").shouldHave(text("SoftAssertions"));

//Открыть страницу SoftAssertions, внутри есть пример кода для JUnit5
        $("div#wiki-pages-box ul").$(byText("SoftAssertions")).click();
        $("div#wiki-body a#user-content-3-using-junit5-extend-test-class")
                .parent().shouldHave(text("Using JUnit5"));
//если нужно весь текст примера кода проверить
        $("div#wiki-body").shouldHave(text("@ExtendWith" +
                "({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
