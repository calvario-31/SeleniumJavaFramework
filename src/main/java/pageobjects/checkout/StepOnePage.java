package pageobjects.checkout;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class StepOnePage extends BasePage {
    private final $ firstNameInput = $(By.id("first-name"));
    private final $ lastNameInput = $(By.id("last-name"));
    private final $ zipCodeInput = $(By.id("postal-code"));
    private final $ continueButton = $(By.id("continue"));
    private final $ cancelButton = $(By.id("cancel"));
    private final $ errorMessage = $(By.cssSelector("h3[data-test='error']"));

    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Step One Page to load")
    public void waitPageToLoad() {
        waitPage(firstNameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Step One Page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(firstNameInput.isDisplayed(), "firstname input is displayed");
        softAssert.assertTrue(lastNameInput.isDisplayed(), "lastname input is displayed");
        softAssert.assertTrue(zipCodeInput.isDisplayed(), "zipcode input is displayed");
        softAssert.assertTrue(continueButton.isDisplayed(), "continue button is displayed");
        softAssert.assertTrue(cancelButton.isDisplayed(), "cancel button is displayed");
        softAssert.assertAll();
    }

    @Step("Filling step one form")
    public void fillForm(String firstName, String lastName, String zipCode) {
        log.info("Filling firstname");
        firstNameInput.sendKeys(firstName);

        log.info("Filling lastname");
        lastNameInput.sendKeys(lastName);

        log.info("Filling zipcode");
        zipCodeInput.sendKeys(zipCode);

        log.info("Clicking on continue");
        continueButton.click();
    }

    @Step("Click on cancel button")
    public void clickOnCancelButton() {
        log.info("Clicking on cancel button");
        cancelButton.click();
    }

    @Step("Verifying error message is correct")
    public void verifyErrorMessage(String text) {
        log.info("Verifying error message is correct");
        softAssert.assertTrue(errorMessage.isDisplayed());
        softAssert.assertEquals(errorMessage.getText(), text);
        softAssert.assertAll();
    }
}
