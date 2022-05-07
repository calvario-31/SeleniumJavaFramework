package org.complete.framework.checkout;

import org.complete.framework.models.ItemModel;
import org.complete.framework.pageobjects.checkout.CartPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.complete.framework.utilities.DataProviders;
import org.complete.framework.utilities.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    private CartPage cartPage;
    private HomeShoppingPage homeShoppingPage;
    private final ItemModel item = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
        commonFlows.addItemsAndGoToCart(item);
    }

    @Test (groups = {SMOKE})
    public void verifyCartTest() {
        cartPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test (groups = {SMOKE})
    public void verifyCartItemsTest() {
        cartPage.verifyItemContents(item.getItemName(), item.getPrice());
    }

    @Test (groups = {SMOKE})
    public void returnToShoppingTest() {
        cartPage.clickOnContinueShopping();
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
