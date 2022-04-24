package org.complete.framework.utilities;

import org.complete.framework.models.CredentialsModel;
import org.complete.framework.pageobjects.credentials.Login;
import org.complete.framework.pageobjects.shopping.HomeShopping;
import org.complete.framework.utilities.reader.CredentialsReader;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final WebDriver driver;
    private Login login;
    private HomeShopping homeShopping;
    private CredentialsModel credentials;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        login = new Login(driver);
        login.goToIndex();
        login.waitPageToLoad();
    }

    public void loginValidUser() {
        credentials = new CredentialsReader().getValidCredentials();
        login = new Login(driver);
        homeShopping = new HomeShopping(driver);

        login.fillCredentials(credentials.getUsername(), credentials.getPassword());
        homeShopping.waitPageToLoad();
    }
}
