package org.complete.framework.utilities;

import org.complete.framework.pageobjects.bars.BurgerMenu;
import org.complete.framework.pageobjects.bars.Footer;
import org.complete.framework.pageobjects.bars.Header;
import org.complete.framework.pageobjects.credentials.LoginPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var login = new LoginPage(driver);
        login.goToIndex();
        login.waitPageToLoad();
    }

    public void loginValidUser() {
        var credentials = new DataProviders().getValidCredentials();
        var login = new LoginPage(driver);
        var homeShopping = new HomeShoppingPage(driver);
        var header = new Header(driver);
        var footer = new Footer(driver);

        login.fillCredentials(credentials.getUsername(), credentials.getPassword());
        homeShopping.waitPageToLoad();
        header.waitPageToLoad();
        footer.waitPageToLoad();
    }

    public void openMenuBurger() {
        var header = new Header(driver);
        var burgerMenu = new BurgerMenu(driver);
        header.openBurgerMenu();
        burgerMenu.waitPageToLoad();
    }
}
