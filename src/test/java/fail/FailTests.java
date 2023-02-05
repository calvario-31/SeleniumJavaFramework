package fail;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;

import static data.DataProviders.ITEM_LIST_DP;

public class FailTests extends BaseTest {
    private SuccessPage successPage;

    @Test
    public void verify1Test() {
        commonFlows.verifyFooterHeader();
    }

    @Test
    public void verify2Test() {
        commonFlows.loginValidUser();
        successPage.verifyPage();
    }

    @Test(dataProvider = ITEM_LIST_DP, dataProviderClass = DataProviders.class)
    public void itemListTest(String name, double price, String id, int quantity) {
        var message = String.format("Name: %s, price: %.2f, id: %s, quantity: %d",
                name, price, id, quantity);
        System.out.println(message);
    }

    @Override
    protected void initPages(WebDriver driver) {
        successPage = new SuccessPage(driver);
    }
}
