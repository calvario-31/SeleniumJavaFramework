package org.complete.framework.bars;

import org.complete.framework.utilities.base.BaseTest;
import org.complete.framework.pageobjects.bars.BurgerMenu;
import org.complete.framework.pageobjects.credentials.LoginPage;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BurgerMenuTests extends BaseTest {
    private BurgerMenu burgerMenu;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
        commonFlows.openMenuBurger();
    }

    @Test(groups = {SMOKE})
    public void verifyContentsTest() {
        burgerMenu.verifyPage();
    }

    @Test(groups = {REGRESSION})
    public void verifyAboutLinkTest() {
        var sauceLabsUrl = new DataProviders().getSauceLabsUrl();
        burgerMenu.verifyAboutLink(sauceLabsUrl);
    }

    @Test(groups = {SMOKE})
    public void logoutTest() {
        burgerMenu.clickOnLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Override
    protected void initPages() {
        burgerMenu = new BurgerMenu(driver);
        loginPage = new LoginPage(driver);
    }
}
