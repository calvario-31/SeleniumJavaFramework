package checkout;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;
import pageobjects.shopping.HomeShoppingPage;
import utilities.CommonFlows;

public class SuccessTests extends BaseTest {
    private SuccessPage successPage;
    private HomeShoppingPage homeShoppingPage;
    private final Item item = DataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.addItemsFinishShopping(item);
    }

    @Test(groups = {smoke, regression})
    public void verifySuccessPageTest() {
        successPage.verifyPage();
        CommonFlows.verifyFooterHeader();
    }

    @Test(groups = {regression})
    public void verifyBackHomeTest() {
        successPage.clickOnBackToHome();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
        CommonFlows.verifyFooterHeader();
    }

    @Override
    protected void initPages() {
        successPage = new SuccessPage();
        homeShoppingPage = new HomeShoppingPage();
    }
}
