package shopping;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.shopping.HomeShoppingPage;

public class ShoppingTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setup() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {smoke})
    public void verifyPageTest() {
        homeShoppingPage.verifyPage();
    }

    @Test(groups = {regression})
    public void comboBoxNameFilterDescendantTest() {
        homeShoppingPage.filterByName(false);
        homeShoppingPage.verifyItemNameOrder(false);
    }

    @Test(groups = {regression})
    public void comboBoxNameFilterAscendantTest() {
        homeShoppingPage.filterByName(true);
        homeShoppingPage.verifyItemNameOrder(true);
    }

    @Test(groups = {regression})
    public void comboBoxPriceFilterDescendantTest() {
        homeShoppingPage.filterByPrice(false);
        homeShoppingPage.verifyItemPriceOrder(false);
    }

    @Test(groups = {regression})
    public void comboBoxPriceFilterAscendantTest() {
        homeShoppingPage.filterByPrice(true);
        homeShoppingPage.verifyItemPriceOrder(true);
    }

    @Override
    protected void initPages(WebDriver driver) {
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
