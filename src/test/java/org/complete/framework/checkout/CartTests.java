package org.complete.framework.checkout;

import org.complete.framework.BaseTest;
import org.complete.framework.pageobjects.checkout.CartPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.complete.framework.utilities.DataProviders.SINGLE_ITEM_DP;

public class CartTests extends BaseTest {
    private CartPage cartPage;
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test (groups = {SMOKE})
    public void verifyCartTest() {
        cartPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test (groups = {SMOKE}, dataProvider = SINGLE_ITEM_DP, dataProviderClass = DataProviders.class)
    public void verifyCartItemsTest(double price, String name, int quantity) {
        cartPage.verifyItemContents(price, name, quantity);
    }

    @Test (groups = {SMOKE})
    public void returnToShoppingTest() {
        cartPage.clickOnContinueCheckout();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Test (groups = {REGRESSION})
    public void removeItemFromListTest() {
        cartPage.clickOnRemoveItem();
        cartPage.verifyListIsEmpty();
    }

    @Override
    protected void initPages() {
        cartPage = new CartPage(driver);
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
