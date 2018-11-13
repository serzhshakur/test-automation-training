import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class MainPage {
    private final SelenideElement carouselElement = $("#homepage-slider");

    void waitForElements() {
        carouselElement.shouldBe(visible);
    }

}
