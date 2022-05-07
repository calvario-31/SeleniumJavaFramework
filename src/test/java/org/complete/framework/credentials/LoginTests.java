package org.complete.framework.credentials;

import org.complete.framework.utilities.base.BaseTest;
import org.complete.framework.pageobjects.credentials.LoginPage;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.Test;

import static org.complete.framework.utilities.DataProviders.INVALID_CREDENTIALS_DP;

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

    @Test(groups = {SMOKE}, dataProvider = INVALID_CREDENTIALS_DP, dataProviderClass = DataProviders.class)
    public void invalidCredentialsTest(String username, String password) {
        loginPage.fillCredentials(username, password);
        loginPage.verifyLockedMessageIsDisplayed();
    }

    @Override
    protected void initPages() {
        loginPage = new LoginPage(driver);
    }
}
