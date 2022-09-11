package checkout;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;
import pageobjects.shopping.HomeShoppingPage;

public class SuccessTests extends BaseTest {
    private SuccessPage successPage;
    private HomeShoppingPage homeShoppingPage;
    private final Item item = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.addItemsFinishShopping(item);
    }

    @Test(groups = {smoke})
    public void verifySuccessPageTest() {
        successPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test(groups = {regression})
    public void verifyBackHomeTest() {
        successPage.clickOnBackToHome();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Override
    protected void initPages(WebDriver webDriver) {
        successPage = new SuccessPage(webDriver);
        homeShoppingPage = new HomeShoppingPage(webDriver);
    }
}
