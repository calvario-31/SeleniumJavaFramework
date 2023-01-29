package pageobjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webelements.single.$;

public class Header extends BasePage {
    private final $ appLogo = $(By.className("app_logo"));
    private final $ cartButton = $(By.className("shopping_cart_link"));
    private final $ burgerMenuButton = $(By.id("react-burger-menu-btn"));

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
        softAssert.assertTrue(appLogo.isDisplayed(), "app logo is displayed");
        softAssert.assertTrue(cartButton.isDisplayed(), "cart button is displayed");
        softAssert.assertTrue(burgerMenuButton.isDisplayed(), "burger menu button is displayed");
        softAssert.assertAll();
    }

    @Step("Opening burger menu")
    public void openBurgerMenu() {
        Logs.info("Opening burger menu");
        burgerMenuButton.click();
    }

    @Step("Clicking on checkout cart")
    public void clickOnCheckoutCart() {
        Logs.info("Clicking on checkout cart");
        cartButton.click();
    }
}
