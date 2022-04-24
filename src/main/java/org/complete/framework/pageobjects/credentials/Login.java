package org.complete.framework.pageobjects.credentials;

import org.complete.framework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends BasePage {
    private final By emailInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By buttonLogin = By.id("login-button");
    private final By loginLogo = By.className("login_logo");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public Login(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(loginLogo, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(loginLogo), "login logo is displayed");
        softAssert.assertTrue(verifyIsDisplayed(emailInput), "email input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(passwordInput), "password input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(buttonLogin), "button login is displayed");
        softAssert.assertAll();
    }

    public void fillCredentials(String username, String password) {
        log.info("Filling username input");
        typeText(emailInput, username);
        log.info("Filling password input");
        typeText(passwordInput, password);
        log.info("Clicking on button login");
        click(buttonLogin);
    }

    public void verifyLockedMessageIsDisplayed() {
        Assert.assertTrue(verifyIsDisplayed(errorMessage));
    }
}
