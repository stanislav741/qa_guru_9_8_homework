package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomepageTest {

    @ValueSource(strings = {"/de/home/", "/en/home/"})
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("High")
    @ParameterizedTest(name = "#1 - NGLB - Homepage - {0} availability")
    void homepageOpen(String homeURL) {
        open("https://neugelb.com" + homeURL);
    }

    @CsvSource({
            "/de/home/, Hallo. Wir sind Neugelb",
            "/en/home/, Hello. We are Neugelb"})
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("High")
    @ParameterizedTest(name = "#2 NGLB - Homepage - {0} - {1} Intro text availability")
    void homepageOpen(String homeURL, String introText) {
        open("https://neugelb.com" + homeURL);
        $(byText(introText)).scrollTo().should(exist);
    }


//        $(byText("Akzeptieren")).click();
//        $(".Burger__BurgerContainer-sc-58me4m-0").click();
//        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text("Home"));
//        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text("Über uns"));
//        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text("Team & Karriere"));
//        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text("Case Studies"));
//        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text("Kontakt"));

}
