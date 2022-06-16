package pageobjects.checkout;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage {
    private final By backToHomeButton = By.id("back-to-products");
    private final By successTitleLabel = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
    private final By successDescriptionLabel = By.xpath("//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']");
    private final By ponyImage = By.className("pony_express");

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
        softAssert.assertTrue(verifyIsDisplayed(backToHomeButton), "back to home button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(successTitleLabel), "success title label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(successDescriptionLabel), "success description label is displayed");
        softAssert.assertTrue(verifyIsDisplayed(ponyImage), "pony image is displayed");
        softAssert.assertAll();
    }

    @Step("Clicking on back to home")
    public void clickOnBackToHome() {
        log.info("Clicking on back to home");
        click(backToHomeButton);
    }
}
