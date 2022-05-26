package org.complete.framework.credentials;

import org.complete.framework.pageobjects.credentials.LoginPage;
import org.complete.framework.utilities.DataProviders;
import org.complete.framework.utilities.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Test(groups = {SMOKE})
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    @Test(groups = {SMOKE})
    public void loginTest() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {SMOKE})
    public void invalidCredentialsTest() {
        var badCredentials = new DataProviders().getInvalidCredentials();
        loginPage.fillCredentials(badCredentials.getUsername(), badCredentials.getPassword());
        loginPage.verifyLockedMessageIsDisplayed();
    }

    @Override
    protected void initPages() {
        loginPage = new LoginPage(driver);
    }
}
