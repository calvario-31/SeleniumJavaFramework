package org.complete.framework.pageobjects.shopping;

import org.complete.framework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeShopping extends BasePage {
    private final By title = By.className("title");

    public HomeShopping(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(title), "title is displayed");
        softAssert.assertAll();
    }
}
