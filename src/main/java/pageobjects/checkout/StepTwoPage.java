package pageobjects.checkout;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webelements.single.$;

public class StepTwoPage extends BasePage {
    private final $ itemNameLabel = $(By.className("inventory_item_name"));
    private final $ itemPriceLabel = $(By.className("inventory_item_price"));
    private final $ itemQuantityLabel = $(By.className("cart_quantity"));
    private final $ quantityLabel = $(By.className("cart_quantity_label"));
    private final $ descriptionLabel = $(By.className("cart_desc_label"));
    private final $ summaryInfoLabel = $(By.className("summary_info_label"));
    private final $ paymentInformationLabel =
            $(By.xpath("//div[text()='Payment Information:']"));
    private final $ shippingInformationLabel =
            $(By.xpath("//div[text()='Shipping Information:']"));
    private final $ subToTalLabel = $(By.className("summary_subtotal_label"));
    private final $ taxLabel = $(By.className("summary_tax_label"));
    private final $ totalLabel = $(By.className("summary_total_label"));
    private final $ finishButton = $(By.id("finish"));
    private final $ cancelButton = $(By.id("cancel"));

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
        softAssert.assertTrue(itemNameLabel.isDisplayed(), "item name label is displayed");
        softAssert.assertTrue(itemPriceLabel.isDisplayed(), "item price label is displayed");
        softAssert.assertTrue(quantityLabel.isDisplayed(), "quantity label is displayed");
        softAssert.assertTrue(descriptionLabel.isDisplayed(), "description label is displayed");
        softAssert.assertTrue(summaryInfoLabel.isDisplayed(), "summary info label is displayed");
        softAssert.assertTrue(paymentInformationLabel.isDisplayed(), "payment information label is displayed");
        softAssert.assertTrue(shippingInformationLabel.isDisplayed(), "shipping information label is displayed");
        softAssert.assertTrue(subToTalLabel.isDisplayed(), "subtotal label is displayed");
        softAssert.assertTrue(taxLabel.isDisplayed(), "tax label is displayed");
        softAssert.assertTrue(finishButton.isDisplayed(), "finish button is displayed");
        softAssert.assertTrue(cancelButton.isDisplayed(), "cancel button is displayed");
        softAssert.assertAll();
    }

    @Step("Verifying item contents {0}")
    public void verifyItemContents(String name, double price) {
        Logs.info("Verifying item row are displayed");
        softAssert.assertTrue(itemQuantityLabel.isDisplayed(), "quantity label is displayed");
        softAssert.assertTrue(itemNameLabel.isDisplayed(), "description label is displayed");
        softAssert.assertTrue(itemPriceLabel.isDisplayed(), "continue shopping button is displayed");
        softAssert.assertAll();

        var itemQuantityUI = Integer.parseInt(itemQuantityLabel.getText());
        var itemPriceUI = Double.parseDouble(itemPriceLabel.getText().substring(1));
        var itemNameUI = itemNameLabel.getText();

        Logs.info("Verifying item contents are correct");
        softAssert.assertEquals(itemPriceUI, price, "price is correct");
        softAssert.assertEquals(itemNameUI, name, "name is correct");
        softAssert.assertEquals(itemQuantityUI, 1, "quantity is correct");
        softAssert.assertAll();
    }

    @Step("Clicking on cancel button")
    public void clickOnCancel() {
        Logs.info("Clicking on cancel button");
        cancelButton.click();
    }

    @Step("Clicking on finish button")
    public void clickOnFinish() {
        Logs.info("Clicking on finish button");
        finishButton.click();
    }
}
