package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ClothesPage {
    private final SelenideElement leftPanelElement = $("#left-column");
    private final SelenideElement categoriesBlock = leftPanelElement.$(".block-categories");
    private final SelenideElement filtersBlock = leftPanelElement.$("#search_filters");

    public ClothesPage waitForElements() {
        categoriesBlock.shouldBe(visible);
        filtersBlock.shouldBe(visible);
        return this;
    }

}
