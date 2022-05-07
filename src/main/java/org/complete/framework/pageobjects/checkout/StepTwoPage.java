package org.complete.framework.pageobjects.checkout;

import io.qameta.allure.Step;
import org.complete.framework.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepTwoPage extends BasePage {
    private final By itemNameLabel = By.className("inventory_item_name");
    private final By itemPriceLabel = By.className("inventory_item_price");
    private final By itemQuantityLabel = By.className("cart_quantity");
    private final By quantityLabel = By.className("cart_quantity_label");
    private final By descriptionLabel = By.className("cart_desc_label");
    private final By summaryInfoLabel = By.className("summary_info_label");
    private final By paymentInformationLabel = By.xpath("//div[text()='Payment Information:']");
    private final By shippingInformationLabel = By.xpath("//div[text()='Shipping Information:']");
    private final By subToTalLabel = By.className("summary_subtotal_label");
    private final By taxLabel = By.className("summary_tax_label");
    private final By totalLabel = By.className("summary_total_label");
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");

    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Step Two Page to load")
    public void waitPageToLoad() {
        waitPage(totalLabel, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Step Two Page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(itemNameLabel), "item name label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemPriceLabel), "item price label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(quantityLabel), "quantity label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(descriptionLabel), "description label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(summaryInfoLabel), "summary info label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(paymentInformationLabel), "payment information label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(shippingInformationLabel), "shipping information label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(subToTalLabel), "subtotal label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(taxLabel), "tax label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(finishButton), "finish button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(cancelButton), "cancel button is displayed");
        softAssert.assertAll();
    }

    @Step("Verifying item contents {0}")
    public void verifyItemContents(String name, double price) {
        log.info("Verifying item row are displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemQuantityLabel), "quantity label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemNameLabel), "description label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(itemPriceLabel), "continue shopping button is displayed");
        softAssert.assertAll();

        var itemQuantityUI = Integer.parseInt(getText(itemQuantityLabel));
        var itemPriceUI = Double.parseDouble(getText(itemPriceLabel).substring(1));
        var itemNameUI = getText(itemNameLabel);

        log.info("Verifying item contents are correct");
        softAssert.assertEquals(itemPriceUI, price, "price is correct");
        softAssert.assertEquals(itemNameUI, name,"name is correct");
        softAssert.assertEquals(itemQuantityUI, 1, "quantity is correct");
        softAssert.assertAll();
    }

    @Step("Clicking on cancel button")
    public void clickOnCancel() {
        log.info("Clicking on cancel button");
        click(cancelButton);
    }

    @Step("Clicking on finish button")
    public void clickOnFinish() {
        log.info("Clicking on finish button");
        click(finishButton);
    }
}
