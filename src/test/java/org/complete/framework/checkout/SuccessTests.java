package org.complete.framework.checkout;

import org.complete.framework.models.ItemModel;
import org.complete.framework.pageobjects.checkout.SuccessPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.complete.framework.utilities.DataProviders;
import org.complete.framework.utilities.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessTests extends BaseTest {
    private SuccessPage successPage;
    private HomeShoppingPage homeShoppingPage;
    private final ItemModel item = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
        commonFlows.addItemsFinishShopping(item);
    }

    @Test(groups = {SMOKE})
    public void verifySuccessPageTest() {
        successPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test(groups = {REGRESSION})
    public void verifyBackHomeTest() {
        successPage.clickOnBackToHome();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Override
    protected void initPages() {
        successPage = new SuccessPage(driver);
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
