import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement carouselElement = $("#carousel");

    public MainPage waitForElements() {
//        carouselElement.shouldBe(visible);
        return this;
    }

}
