package org.complete.framework.checkout;

import base.BaseTest;
import models.ItemModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;
import pageobjects.shopping.HomeShoppingPage;
import utilities.DataProviders;

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
