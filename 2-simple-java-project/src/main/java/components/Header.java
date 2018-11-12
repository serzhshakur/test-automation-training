package components;

import com.codeborne.selenide.SelenideElement;
import pages.ClothesPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Header {
    private final SelenideElement logoElement = $("#logo");
    private final SelenideElement exploreBackofficeButton = $(".btn-explore-bo");
    private final SelenideElement downloadButton = $(".btn-download");
    private final SelenideElement contactLink = $("#contact-link");
    private final SelenideElement languageSelector = $(".language-selector");
    private final SelenideElement signInButton = $("#_desktop_user_info");
    private final SelenideElement cartButton = $("#_desktop_cart");
    private final SelenideElement topMenu = $("#top-menu");
    private final SelenideElement clothesCategory = topMenu.$("#category-3 a[href*='/3-clothes']");

    public Header waitForElements() {
        logoElement.shouldBe(visible);
        exploreBackofficeButton.shouldBe(visible);
        downloadButton.shouldBe(visible);
        contactLink.shouldBe(visible);
        languageSelector.shouldBe(visible);
        signInButton.shouldBe(visible);
        cartButton.shouldBe(visible);
        clothesCategory.shouldBe(visible);
        return this;
    }

    public ClothesPage goToClothesCategory() {
        clothesCategory.click();
        return new ClothesPage();
    }

}
