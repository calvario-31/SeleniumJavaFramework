package org.complete.framework.pageobjects.checkout;

import io.qameta.allure.Step;
import org.complete.framework.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    private final By quantityLabel = By.className("cart_quantity_label");
    private final By descriptionLabel = By.className("cart_desc_label");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By itemQuantity = By.className("cart_quantity");
    private final By itemName = By.className("inventory_item_name");
    private final By itemPrice = By.className("inventory_item_price");
    private final By removeItemButton = By.xpath("//button[text()='Remove']");
    private final By cartItemRow = By.className("cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Cart Page to load")
    public void waitPageToLoad() {
        waitPage(quantityLabel, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Cart Page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(quantityLabel), "quantity label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(descriptionLabel), "description label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(continueShoppingButton), "continue shopping button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(checkoutButton), "checkout button is displayed");
        softAssert.assertAll();
    }

    @Step("Verify item contents")
    public void verifyItemContents(double price, String name) {
        log.info("Verifying item row are displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemQuantity), "quantity label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemName), "description label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemPrice), "continue shopping button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(removeItemButton), "checkout button is displayed");
        softAssert.assertAll();

        var itemQuantityUI = Integer.parseInt(getText(itemQuantity));
        var itemPriceUI = Double.parseDouble(getText(itemPrice).substring(1));
        var itemNameUI = getText(itemName);

        log.info("Verifying item contents are correct");
        softAssert.assertEquals(itemPriceUI, price, "price is correct");
        softAssert.assertEquals(itemNameUI, name,"name is correct");
        softAssert.assertEquals(itemQuantityUI, 1, "quantity is correct");
        softAssert.assertAll();
    }

    @Step("Click on continue checkout")
    public void clickOnContinueCheckout() {
        log.info("Clicking on continue checkout");
        click(checkoutButton);
    }

    @Step("Click on continue shopping")
    public void clickOnContinueShopping() {
        log.info("Clicking on continue shopping");
        click(continueShoppingButton);
    }

    @Step("Click on remove item")
    public void clickOnRemoveItem() {
        log.info("Click on remove item");
        click(removeItemButton);
    }

    @Step("Verifying list is empty")
    public void verifyListIsEmpty() {
        log.info("Verifying list is empty");
        Assert.assertTrue(verifyIsNotDisplayed(cartItemRow));
    }
}
