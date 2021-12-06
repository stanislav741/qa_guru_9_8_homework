package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomepageTest {
    String varBaseURL = "https://neugelb.com";
    
//TC #1.1, #1.2
    @ParameterizedTest(name = "#1 - NGLB - Homepage - {0} availability")
    @Order(1)
    @ValueSource(strings = {"/de/home/", "/en/home/"})
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("High")
    void homepageOpen(String homeURL) {
        open(varBaseURL + homeURL);
    }

//TC #2.1, #2.2
    @ParameterizedTest(name = "#2 NGLB - Homepage - {0} - {1} Intro text availability")
    @Order(2)
    @CsvSource({
            "/de/home/, Hallo. Wir sind Neugelb",
            "/en/home/, Hello. We are Neugelb"})
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("Medium")
    void homepageOpenIntro(String homeURL, String introText) {
        open(varBaseURL + homeURL);
        $(byText(introText)).should(exist);
    }

//TC #3.1, #3.2
    static Stream<Arguments> cookiesConsentElements() {
        return Stream.of(
                Arguments.of("/de/home/", "Einwilligung verwalten", "Akzeptieren"),
                Arguments.of("/en/home/", "Management Consent", "Accept")
        );
    }
    @ParameterizedTest(name = "#3 NGLB - Homepage - {0} - {1} {2}")
    @Order(3)
    @MethodSource("cookiesConsentElements")
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("Low")
    void cookiesConsent(String homeURL, String consentTitle, String consentButton) {
        open(varBaseURL + homeURL);
        $(byText(consentTitle)).should(exist);
        $(byText(consentButton)).click();

    }

//TC #4.1, #4.2
    @ParameterizedTest(name = "#4 NGLB - Homepage - {0} - Menu items availability")
    @Order(4)
    @CsvFileSource(resources = "/menuitems.csv")
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("Low")
    void menuItemsCheck(String homeURL, String home, String aboutUs, String teamAndCareer, String caseStudies, String contact) {
        open(varBaseURL + homeURL);
        $(".Burger__BurgerContainer-sc-58me4m-0").click();
        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text(home));
        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text(aboutUs));
        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text(teamAndCareer));
        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text(caseStudies));
        $(".Menu__ListContainer-sc-23iy1o-1").shouldHave(text(contact));
    }

//TC #5.1, #5.2
//Я не до конца понял как работает параметризация через Enum. Решение было скопировано у одного из других учеников. См. дополнительную информацию в tests/LanguageSwitcher.java
    @ParameterizedTest(name = "#5 NGLB - Homepage - {0} language switcher availability")
    @Order(5)
    @EnumSource(LanguageSwitcher.class)
    @DisplayName("Test Suite - NGLB - Homepage")
    @Tag("Low")
    void languageSwitcherCheck(LanguageSwitcher languageSwitcher) {

        open(varBaseURL + languageSwitcher.getUrl());
        $(".Burger__BurgerContainer-sc-58me4m-0").click();
        $(".language-switch").shouldHave(text(languageSwitcher.getTitle()));
    }

}
