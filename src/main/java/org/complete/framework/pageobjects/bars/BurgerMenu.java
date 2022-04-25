package org.complete.framework.pageobjects.bars;

import org.complete.framework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BurgerMenu extends BasePage {
    private final By itemList = By.className("bm-item-list");
    private final By allItemsOption = By.id("inventory_sidebar_link");
    private final By aboutOption = By.id("about_sidebar_link");
    private final By logoutOption = By.id("logout_sidebar_link");

    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(itemList, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(itemList), "item is displayed");
        softAssert.assertTrue(verifyIsDisplayed(allItemsOption), "all items option is displayed");
        softAssert.assertTrue(verifyIsDisplayed(aboutOption), "about option is displayed");
        softAssert.assertTrue(verifyIsDisplayed(logoutOption), "logout option is displayed");
        softAssert.assertAll();
    }

    public void verifyAboutLink(String expectedLink) {
        var actualLink = getHref(aboutOption);
        log.info("Verifying about link");
        Assert.assertEquals(actualLink, expectedLink);

        log.info("Verifying option is clickable");
        Assert.assertTrue(verifyIsClickable(aboutOption));
    }

    public void clickOnLogout() {
        log.info("Clicking on logout option");
        click(logoutOption);
    }

    public void clickOnAllItems() {
        log.info("Clicking on all items option");
        click(allItemsOption);
    }
}
