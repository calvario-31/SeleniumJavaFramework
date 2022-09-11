package pageobjects.shopping;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webelements.single.$;

public class ItemDetailPage extends BasePage {
    private final $ addToCartButton = $(By.xpath("//button[text()='Add to cart']"));
    private final $ backToProductsButton = $(By.id("back-to-products"));
    private final $ nameLabel = $(By.className("inventory_details_name"));
    private final $ priceLabel = $(By.className("inventory_details_price"));
    private final $ itemImage = $(By.className("inventory_details_img"));

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
        softAssert.assertTrue(addToCartButton.isDisplayed(), "add to cart button is displayed");
        softAssert.assertTrue(backToProductsButton.isDisplayed(), "back to products is displayed");
        softAssert.assertTrue(nameLabel.isDisplayed(), "name label is displayed");
        softAssert.assertTrue(priceLabel.isDisplayed(), "price label is displayed");
        softAssert.assertTrue(itemImage.isDisplayed(), "item image is displayed");
        softAssert.assertAll();
    }

    @Step("Clicking on adding item to cart")
    public void clickingOnAddItemToCart() {
        log.info("Clicking on adding item to cart");
        addToCartButton.click();
    }

    @Step("Clicking on back to products")
    public void clickOnBackToProducts() {
        log.info("Clicking on back to products");
        backToProductsButton.click();
    }

    @Step("Verifying correct item display for item")
    public void verifyCorrectItemDisplay(String name, double price) {
        var nameUI = nameLabel.getText();
        var priceUI = Double.parseDouble(priceLabel.getText().substring(1));

        softAssert.assertEquals(nameUI, name, "name are the same");
        softAssert.assertEquals(priceUI, price, "price are the same");
        softAssert.assertAll();
    }
}
