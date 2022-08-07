package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class findLinkTest {

    /**
     * h1 div найдет все элементы, совпадающие с указанным локатором и вернет первый подходящий под эти условия элемент
     * $("h1").$("div") найдет первый элемент с тэгом h1 и в нем будет искать тэг div
     * Если в первый тэг h1 не будет содержать в себе div, то во втором случае элемент не будет найден
     */
    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void selenideTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
