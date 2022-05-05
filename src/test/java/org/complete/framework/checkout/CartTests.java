package org.complete.framework.checkout;

import org.complete.framework.BaseTest;
import org.complete.framework.models.ItemModel;
import org.complete.framework.pageobjects.bars.Header;
import org.complete.framework.pageobjects.checkout.CartPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    private CartPage cartPage;
    private HomeShoppingPage homeShoppingPage;
    private Header header;
    private final ItemModel itemToAdd = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
        commonFlows.addSingleItemToCart(itemToAdd);
        header.clickOnCheckoutCart();
        cartPage.waitPageToLoad();
    }

    @Test (groups = {SMOKE})
    public void verifyCartTest() {
        cartPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test (groups = {SMOKE})
    public void verifyCartItemsTest() {
        cartPage.verifyItemContents(itemToAdd.getPrice(), itemToAdd.getItemName());
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
        header = new Header(driver);
    }
}
