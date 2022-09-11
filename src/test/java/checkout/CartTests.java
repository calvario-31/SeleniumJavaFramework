package checkout;

import base.BaseTest;
import data.DataProviders;
import models.ItemModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.CartPage;
import pageobjects.shopping.HomeShoppingPage;

public class CartTests extends BaseTest {
    private CartPage cartPage;
    private HomeShoppingPage homeShoppingPage;
    private final ItemModel item = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.addItemsAndGoToCart(item);
    }

    @Test(groups = {smoke})
    public void verifyCartTest() {
        cartPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test(groups = {smoke})
    public void verifyCartItemsTest() {
        cartPage.verifyItemContents(item.getItemName(), item.getPrice());
    }

    @Test(groups = {smoke})
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
    protected void initPages(WebDriver webDriver) {
        cartPage = new CartPage(webDriver);
        homeShoppingPage = new HomeShoppingPage(webDriver);
    }
}
