package org.complete.framework.utilities;

import org.complete.framework.models.CredentialModel;
import org.complete.framework.pageobjects.bars.BurgerMenu;
import org.complete.framework.pageobjects.bars.Header;
import org.complete.framework.pageobjects.credentials.LoginPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final WebDriver driver;
    private LoginPage login;
    private HomeShoppingPage homeShopping;
    private CredentialModel credentials;
    private Header header;
    private BurgerMenu burgerMenu;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        login = new LoginPage(driver);
        login.goToIndex();
        login.waitPageToLoad();
    }

    public void loginValidUser() {
        credentials = new DataProviders().getValidCredentials();
        login = new LoginPage(driver);
        homeShopping = new HomeShoppingPage(driver);

        login.fillCredentials(credentials.getUsername(), credentials.getPassword());
        homeShopping.waitPageToLoad();
    }

    public void openMenuBurger() {
        header = new Header(driver);
        header.openBurgerMenu();
        burgerMenu = new BurgerMenu(driver);
        burgerMenu.waitPageToLoad();
    }
}
