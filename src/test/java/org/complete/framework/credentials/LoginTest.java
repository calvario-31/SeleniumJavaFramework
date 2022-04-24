package org.complete.framework.credentials;

import org.complete.framework.BaseTest;
import org.complete.framework.models.CredentialsModel;
import org.complete.framework.pageobjects.credentials.Login;
import org.complete.framework.utilities.reader.CredentialsReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private Login login;
    private final String INVALID_DATA_PROVIDER = "invalid credentials";

    @Test(groups = {SMOKE})
    public void verifyLoginPageTest() {
        login.verifyPage();
    }

    @Test(groups = {SMOKE})
    public void loginTest() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {SMOKE}, dataProvider = INVALID_DATA_PROVIDER)
    public void invalidCredentialsTest(CredentialsModel credentialsModel) {
        login.fillCredentials(credentialsModel.getUsername(), credentialsModel.getPassword());
        login.verifyLockedMessageIsDisplayed();
    }

    @Override
    protected void initPages() {
        login = new Login(driver);
    }

    @DataProvider(name = INVALID_DATA_PROVIDER)
    private Object[][] invalidDataProvider() {
        CredentialsModel credentials = new CredentialsReader().getLockedCredentials();
        return new Object[][]{{credentials}};
    }
}
