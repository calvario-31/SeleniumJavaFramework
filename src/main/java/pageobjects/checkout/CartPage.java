package pageobjects.checkout;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webelements.single.$;

public class CartPage extends BasePage {
    private final $ quantityLabel = $(By.className("cart_quantity_label"));
    private final $ descriptionLabel = $(By.className("cart_desc_label"));
    private final $ continueShoppingButton = $(By.id("continue-shopping"));
    private final $ checkoutButton = $(By.id("checkout"));
    private final $ itemQuantity = $(By.className("cart_quantity"));
    private final $ itemName = $(By.className("inventory_item_name"));
    private final $ itemPrice = $(By.className("inventory_item_price"));
    private final $ removeItemButton = $(By.xpath("//button[text()='Remove']"));
    private final $ cartItemRow = $(By.className("cart_item"));

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
        softAssert.assertTrue(quantityLabel.isDisplayed(), "quantity label is displayed");
        softAssert.assertTrue(descriptionLabel.isDisplayed(), "description label is displayed");
        softAssert.assertTrue(continueShoppingButton.isDisplayed(), "continue shopping button is displayed");
        softAssert.assertTrue(checkoutButton.isDisplayed(), "checkout button is displayed");
        softAssert.assertAll();
    }

    @Step("Verify item contents")
    public void verifyItemContents(String name, double price) {
        log.info("Verifying item row are displayed");
        softAssert.assertTrue(itemQuantity.isDisplayed(), "quantity label is displayed");
        softAssert.assertTrue(itemName.isDisplayed(), "description label is displayed");
        softAssert.assertTrue(itemPrice.isDisplayed(), "continue shopping button is displayed");
        softAssert.assertTrue(removeItemButton.isDisplayed(), "checkout button is displayed");
        softAssert.assertAll();

        var itemQuantityUI = Integer.parseInt(itemQuantity.getText());
        var itemPriceUI = Double.parseDouble(itemPrice.getText().substring(1));
        var itemNameUI = itemName.getText();

        log.info("Verifying item contents are correct");
        softAssert.assertEquals(itemPriceUI, price, "price is correct");
        softAssert.assertEquals(itemNameUI, name, "name is correct");
        softAssert.assertEquals(itemQuantityUI, 1, "quantity is correct");
        softAssert.assertAll();
    }

    @Step("Click on continue checkout")
    public void clickOnContinueCheckout() {
        log.info("Clicking on continue checkout");
        checkoutButton.click();
    }

    @Step("Click on continue shopping")
    public void clickOnContinueShopping() {
        log.info("Clicking on continue shopping");
        continueShoppingButton.click();
    }

    @Step("Click on remove item")
    public void clickOnRemoveItem() {
        log.info("Click on remove item");
        removeItemButton.click();
    }

    @Step("Verifying list is empty")
    public void verifyListIsEmpty() {
        log.info("Verifying list is empty");
        Assert.assertFalse(cartItemRow.isDisplayed());
    }
}
