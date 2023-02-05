package shopping;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.shopping.ItemDetailPage;
import utilities.CommonFlows;

public class ItemDetailTests extends BaseTest {
    private ItemDetailPage itemDetailPage;
    private final Item item = DataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.goToItemDetail(item);
    }

    @Test(groups = {smoke, regression})
    public void verifyItemDetailTest() {
        itemDetailPage.verifyPage();
        itemDetailPage.verifyCorrectItemDisplay(item.getItemName(), item.getPrice());
    }

    @Override
    protected void initPages() {
        itemDetailPage = new ItemDetailPage();
    }
}
