package bars;

import base.BaseTest;
import data.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.BurgerMenu;
import pageobjects.credentials.LoginPage;
import utilities.CommonFlows;

public class BurgerMenuTests extends BaseTest {
    private BurgerMenu burgerMenu;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.openMenuBurger();
    }

    @Test(groups = {smoke, regression})
    public void verifyContentsTest() {
        burgerMenu.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyAboutLinkTest() {
        final var sauceLabsUrl = DataProviders.getSauceLabsUrl();
        burgerMenu.verifyAboutLink(sauceLabsUrl);
    }

    @Test(groups = {smoke, regression})
    public void logoutTest() {
        burgerMenu.clickOnLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Override
    protected void initPages() {
        burgerMenu = new BurgerMenu();
        loginPage = new LoginPage();
    }
}
