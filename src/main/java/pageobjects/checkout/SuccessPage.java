package pageobjects.checkout;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webelements.single.$;

public class SuccessPage extends BasePage {
    private final $ backToHomeButton = $(By.id("back-to-products"));
    private final $ successTitleLabel =
            $(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
    private final $ ponyImage = $(By.className("pony_express"));
    private final $ successDescriptionLabel =
            $(By.xpath("//div[contains(text(), 'Your order has been dispatched')]"));

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Success Page to load")
    public void waitPageToLoad() {
        waitPage(ponyImage, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Success Page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(backToHomeButton.isDisplayed(), "back to home button is displayed");
        softAssert.assertTrue(successTitleLabel.isDisplayed(), "success title label is displayed");
        softAssert.assertTrue(successDescriptionLabel.isDisplayed(), "success description label is displayed");
        softAssert.assertTrue(ponyImage.isDisplayed(), "pony image is displayed");
        softAssert.assertAll();
    }

    @Step("Clicking on back to home")
    public void clickOnBackToHome() {
        log.info("Clicking on back to home");
        backToHomeButton.click();
    }
}
