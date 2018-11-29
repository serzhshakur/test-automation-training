package com.training.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement productImage = $("#bigpic");
    private final SelenideElement buyBlock = $("#buy_block");
    private final SelenideElement productName = $("[itemprop=name]");
    private final SelenideElement productDescription = $(".page-product-box");

    public ProductPage waitForElements() {
        productImage.shouldBe(visible);
        buyBlock.shouldBe(visible);
        productName.shouldBe(visible);
        productDescription.shouldBe(visible);
        return this;
    }

    public void productNameContains(String text) {
        productName.shouldHave(text(text));
    }

}
