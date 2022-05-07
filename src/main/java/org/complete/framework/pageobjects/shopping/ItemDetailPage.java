package org.complete.framework.pageobjects.shopping;

import io.qameta.allure.Step;
import org.complete.framework.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailPage extends BasePage {
    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private final By backToProductsButton = By.id("back-to-products");
    private final By nameLabel = By.className("inventory_details_name");
    private final By priceLabel = By.className("inventory_details_price");
    private final By itemImage = By.className("inventory_details_img");

    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Verifying item detail page to load")
    public void waitPageToLoad() {
        waitPage(itemImage, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying item detail page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(addToCartButton), "add to cart button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(backToProductsButton), "back to products is displayed");
        softAssert.assertTrue(verifyIsDisplayed(nameLabel), "name label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(priceLabel), "price label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemImage), "item image is displayed");
        softAssert.assertAll();
    }

    @Step("Clicking on adding item to cart")
    public void clickingOnAddItemToCart() {
        log.info("Clicking on adding item to cart");
        click(addToCartButton);
    }

    @Step("Clicking on back to products")
    public void clickOnBackToProducts() {
        log.info("Clicking on back to products");
        click(backToProductsButton);
    }

    @Step("Verifying correct item display for item")
    public void verifyCorrectItemDisplay(String name, double price) {
        var nameUI = getText(nameLabel);
        var priceUI = Double.parseDouble(getText(priceLabel).substring(1));

        softAssert.assertEquals(nameUI, name, "name are the same");
        softAssert.assertEquals(priceUI, price, "price are the same");
        softAssert.assertAll();
    }
}
