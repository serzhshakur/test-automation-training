package com.training.web.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class CustomCondition {

    public static Condition hasChild(final By childLocator) {
        return new Condition("hasChild") {
            @Override
            public boolean apply(Driver driver, WebElement element) {
                return element.findElements(childLocator).size() > 0;
            }

            @Override
            public String actualValue(Driver driver, WebElement element) {
                return element.toString();
            }
        };
    }

}
