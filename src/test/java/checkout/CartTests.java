package checkout;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.CartPage;
import pageobjects.shopping.HomeShoppingPage;
import utilities.CommonFlows;

public class CartTests extends BaseTest {
    private CartPage cartPage;
    private HomeShoppingPage homeShoppingPage;
    private final Item item = DataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.addItemsAndGoToCart(item);
    }

    @Test(groups = {smoke, regression})
    public void verifyCartTest() {
        cartPage.verifyPage();
        CommonFlows.verifyFooterHeader();
    }

    @Test(groups = {smoke, regression})
    public void verifyCartItemsTest() {
        cartPage.verifyItemContents(item.getItemName(), item.getPrice());
    }

    @Test(groups = {smoke, regression})
    public void returnToShoppingTest() {
        cartPage.clickOnContinueShopping();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Test(groups = {regression})
    public void removeItemFromListTest() {
        cartPage.clickOnRemoveItem();
        cartPage.verifyListIsEmpty();
    }

    @Override
    protected void initPages() {
        cartPage = new CartPage();
        homeShoppingPage = new HomeShoppingPage();
    }
}
