package org.complete.framework.pageobjects.bars;

import io.qameta.allure.Step;
import org.complete.framework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    private final By appLogo = By.className("app_logo");
    private final By cartButton = By.className("shopping_cart_link");
    private final By burgerMenuButton = By.id("react-burger-menu-btn");

    public Header(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting header to load")
    public void waitPageToLoad() {
        waitPage(appLogo, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying header")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(appLogo), "app logo is displayed");
        softAssert.assertTrue(verifyIsDisplayed(cartButton), "cart button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(burgerMenuButton), "burger menu button is displayed");
        softAssert.assertAll();
    }

    @Step("Opening burger menu")
    public void openBurgerMenu() {
        log.info("Opening burger menu");
        click(burgerMenuButton);
    }

    @Step("Clicking on checkout cart")
    public void clickOnCheckoutCart() {
        log.info("Clicking on checkout cart");
        click(cartButton);
    }
}
