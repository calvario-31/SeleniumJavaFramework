package checkout;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.StepTwoPage;
import pageobjects.shopping.HomeShoppingPage;
import utilities.CommonFlows;

public class StepTwoTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;
    private StepTwoPage stepTwoPage;
    private final Item item = DataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.addItemsAndGoToStepTwo(item);
    }

    @Test(groups = {smoke, regression})
    public void verifyStepTwoTest() {
        stepTwoPage.verifyPage();
        CommonFlows.verifyFooterHeader();
    }

    @Test(groups = {smoke, regression})
    public void verifyItemContentsTest() {
        stepTwoPage.verifyItemContents(item.getItemName(), item.getPrice());
    }

    @Test(groups = {regression})
    public void verifyReturnToStepOne() {
        stepTwoPage.clickOnCancel();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
        CommonFlows.verifyFooterHeader();
    }

    @Override
    protected void initPages() {
        homeShoppingPage = new HomeShoppingPage();
        stepTwoPage = new StepTwoPage();
    }
}
