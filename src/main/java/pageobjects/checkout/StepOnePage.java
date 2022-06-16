package pageobjects.checkout;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepOnePage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

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
        softAssert.assertTrue(verifyIsDisplayed(firstNameInput), "firstname input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(lastNameInput), "lastname input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(zipCodeInput), "zipcode input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(continueButton), "continue button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(cancelButton), "cancel button is displayed");
        softAssert.assertAll();
    }

    @Step("Filling step one form")
    public void fillForm(String firstName, String lastName, String zipCode) {
        log.info("Filling firstname");
        typeText(firstNameInput, firstName);

        log.info("Filling lastname");
        typeText(lastNameInput, lastName);

        log.info("Filling zipcode");
        typeText(zipCodeInput, zipCode);

        log.info("Clicking on continue");
        click(continueButton);
    }

    @Step("Click on cancel button")
    public void clickOnCancelButton() {
        log.info("Clicking on cancel button");
        click(cancelButton);
    }

    @Step("Verifying error message")
    public void verifyErrorMessage(String text) {
        log.info("Verifying error message is displayed");
        verifyIsDisplayed(errorMessage);

        log.info("Verifying error message is correct");
        var textUI = getText(errorMessage);
        Assert.assertEquals(textUI, text);
    }
}
