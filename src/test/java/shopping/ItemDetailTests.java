package shopping;

import base.BaseTest;
import models.Item;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.shopping.ItemDetailPage;

public class ItemDetailTests extends BaseTest {
    private ItemDetailPage itemDetailPage;
    private final Item item = dataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.goToItemDetail(item);
    }

    @Test(groups = {smoke})
    public void verifyItemDetailTest() {
        itemDetailPage.verifyPage();
        itemDetailPage.verifyCorrectItemDisplay(item.getItemName(), item.getPrice());
    }

    @Override
    protected void initPages(WebDriver webDriver) {
        itemDetailPage = new ItemDetailPage(webDriver);
    }
}
