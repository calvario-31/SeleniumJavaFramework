package pageobjects.credentials;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.Logs;
import webelements.single.$;

public class LoginPage extends BasePage {
    private final $ emailInput = $(By.id("user-name"));
    private final $ passwordInput = $(By.id("password"));
    private final $ buttonLogin = $(By.id("login-button"));
    private final $ loginLogo = $(By.className("login_logo"));
    private final $ errorMessage = $(By.cssSelector("h3[data-test='error']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting login page to load")
    public void waitPageToLoad() {
        waitPage(loginLogo, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying login page")
    public void verifyPage() {
        softAssert.assertTrue(loginLogo.isDisplayed(), "login logo is displayed");
        softAssert.assertTrue(emailInput.isDisplayed(), "email input is displayed");
        softAssert.assertTrue(passwordInput.isDisplayed(), "password input is displayed");
        softAssert.assertTrue(buttonLogin.isDisplayed(), "button login is displayed");
        softAssert.assertAll();
    }

    @Step("Filling credentials")
    public void fillCredentials(String username, String password) {
        Logs.info("Filling username input");
        emailInput.sendKeys(username);

        Logs.info("Filling password input");
        passwordInput.sendKeys(password);

        Logs.info("Clicking on button login");
        buttonLogin.click();
    }

    @Step("Verifying locked message is displayed")
    public void verifyLockedMessageIsDisplayed() {
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
