package com.training.web.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import com.training.web.pages.DressesPage;
import com.training.web.pages.ProductPage;
import com.training.web.selenide.CustomCondition;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Header {
    private final SelenideElement logoElement = $("#header_logo");
    private final SelenideElement contactLink = $("#contact-link");
    private final SelenideElement loginLink = $(".login");
    private final SelenideElement searchBlock = $("#searchbox");
    private final SelenideElement searchInput = searchBlock.$(".search_query");
    private final SelenideElement searchSuggestionsBlock = $(".ac_results");
    private final ElementsCollection searchSuggestionsElements = searchSuggestionsBlock.$$("li");
    private final SelenideElement searchButton = searchBlock.$(".button-search");
    private final SelenideElement topMenu = $("#block_top_menu");
    private final ElementsCollection topMenuLinks = topMenu.$$(".menu-content>li>a");
    private final SelenideElement womenCategoryTab = topMenuLinks.find(attribute("title", "Women"));
    private final SelenideElement dressesCategoryTab = topMenuLinks.find(attribute("title", "Dresses"));
    private final SelenideElement tShirtsCategoryTab = topMenuLinks.find(attribute("title", "T-shirts"));

    public Header waitForElements() {
        logoElement.shouldBe(visible);
        contactLink.shouldBe(visible);
        loginLink.shouldBe(visible);
        searchInput.shouldBe(visible);
        searchButton.shouldBe(visible);
        womenCategoryTab.shouldBe(visible);
        dressesCategoryTab.shouldBe(visible);
        tShirtsCategoryTab.shouldBe(visible);
        return this;
    }

    public DressesPage chooseDressesCategory() {
        dressesCategoryTab.click();
        return new DressesPage();
    }

    public Header enterSearchTerm(String searchTerm) {
        searchInput.val(searchTerm);
        return this;
    }

    public Header waitForSearchSuggestionsBlock() {
        searchSuggestionsBlock.shouldBe(visible);
        return this;
    }

    public ProductPage chooseFirstMatchingSuggestion() {
        searchSuggestionsElements.find(CustomCondition.hasChild(By.tagName("strong"))).click();
        return new ProductPage();
    }

}
