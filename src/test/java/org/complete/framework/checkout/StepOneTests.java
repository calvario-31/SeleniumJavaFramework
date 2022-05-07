package org.complete.framework.checkout;

import org.complete.framework.models.ItemModel;
import org.complete.framework.utilities.base.BaseTest;
import org.complete.framework.pageobjects.checkout.CartPage;
import org.complete.framework.pageobjects.checkout.StepOnePage;
import org.complete.framework.pageobjects.checkout.StepTwoPage;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.complete.framework.utilities.DataProviders.BAD_PERSONAL_INFO_DP;
import static org.complete.framework.utilities.DataProviders.PERSONAL_INFO_DP;

public class StepOneTests extends BaseTest {
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;
    private CartPage cartPage;
    private final ItemModel item = new DataProviders().getSingleItem();

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
        commonFlows.addItemsAndGoToStepOne(item);
    }

    @Test(groups = {SMOKE})
    public void verifyStepOnePageTest() {
        stepOnePage.verifyPage();
    }

    @Test(groups = {SMOKE}, dataProvider = PERSONAL_INFO_DP, dataProviderClass = DataProviders.class)
    public void validDataTest(String firstName, String lastName, String zipCode) {
        stepOnePage.fillForm(firstName, lastName, zipCode);
        stepTwoPage.waitPageToLoad();
    }

    @Test(groups = {REGRESSION})
    public void clickOnCancelReturnsCartPage() {
        stepOnePage.clickOnCancelButton();
        cartPage.waitPageToLoad();
        cartPage.verifyPage();
    }

    @Test(groups = {REGRESSION}, dataProvider = BAD_PERSONAL_INFO_DP, dataProviderClass = DataProviders.class)
    public void invalidDataTest(String firstName, String lastName, String zipCode, String errorMessage) {
        stepOnePage.fillForm(firstName, lastName, zipCode);
        stepOnePage.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages() {
        stepOnePage = new StepOnePage(driver);
        stepTwoPage = new StepTwoPage(driver);
        cartPage = new CartPage(driver);
    }
}
