package org.complete.framework.checkout;

import org.complete.framework.models.ItemModel;
import org.complete.framework.pageobjects.checkout.StepTwoPage;
import org.complete.framework.pageobjects.shopping.HomeShoppingPage;
import org.complete.framework.utilities.DataProviders;
import org.complete.framework.utilities.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StepTwoTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;
    private StepTwoPage stepTwoPage;
    private final ItemModel item = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
        commonFlows.addItemsAndGoToStepTwo(item);
    }

    @Test(groups = {SMOKE})
    public void verifyStepTwoTest() {
        stepTwoPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test(groups = {SMOKE})
    public void verifyItemContentsTest() {
        stepTwoPage.verifyItemContents(item.getItemName(), item.getPrice());
    }

    @Test(groups = {REGRESSION})
    public void verifyReturnToStepOne() {
        stepTwoPage.clickOnCancel();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Override
    protected void initPages() {
        homeShoppingPage = new HomeShoppingPage(driver);
        stepTwoPage = new StepTwoPage(driver);
    }
}
