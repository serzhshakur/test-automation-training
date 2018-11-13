package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DressesPage {
    private final SelenideElement leftPanelElement = $("#left_column");
    private final SelenideElement categoriesBlock = leftPanelElement.$("#categories_block_left");
    private final SelenideElement filtersBlock = leftPanelElement.$("#layered_block_left");

    public DressesPage waitForElements() {
        categoriesBlock.shouldBe(visible);
        filtersBlock.shouldBe(visible);
        return this;
    }

}
