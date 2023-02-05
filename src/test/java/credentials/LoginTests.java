package credentials;

import base.BaseTest;
import data.DataProviders;
import org.testng.annotations.Test;
import pageobjects.credentials.LoginPage;
import utilities.CommonFlows;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Test(groups = {smoke, regression})
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    @Test(groups = {smoke, regression})
    public void loginTest() {
        CommonFlows.loginValidUser();
    }

    @Test(groups = {smoke, regression})
    public void invalidCredentialsTest() {
        final var badCredentials = DataProviders.getInvalidCredentials();
        loginPage.fillCredentials(badCredentials.getUsername(), badCredentials.getPassword());
        loginPage.verifyLockedMessageIsDisplayed();
    }

    @Override
    protected void initPages() {
        loginPage = new LoginPage();
    }
}
