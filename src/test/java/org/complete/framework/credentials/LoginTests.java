package org.complete.framework.credentials;

import base.BaseTest;
import org.testng.annotations.Test;
import pageobjects.credentials.LoginPage;
import utilities.DataProviders;

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
