package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement carouselElement = $("#homepage-slider");

    public void waitForElements() {
        carouselElement.shouldBe(visible);
    }

}
