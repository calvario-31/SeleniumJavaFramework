package checkout;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.CartPage;
import pageobjects.checkout.StepOnePage;
import pageobjects.checkout.StepTwoPage;
import utilities.CommonFlows;

import static data.DataProviders.BAD_PERSONAL_INFO_DP;

public class StepOneTests extends BaseTest {
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;
    private CartPage cartPage;
    private final Item item = DataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.addItemsAndGoToStepOne(item);
    }

    @Test(groups = {smoke, regression})
    public void verifyStepOnePageTest() {
        stepOnePage.verifyPage();
    }

    @Test(groups = {smoke, regression})
    public void validDataTest() {
        final var personalInfo = DataProviders.getPersonalInfo();
        stepOnePage.fillForm(personalInfo.getFirstName(), personalInfo.getLastName(),
                personalInfo.getZipCode());
        stepTwoPage.waitPageToLoad();
    }

    @Test(groups = {regression})
    public void clickOnCancelReturnsCartPage() {
        stepOnePage.clickOnCancelButton();
        cartPage.waitPageToLoad();
        cartPage.verifyPage();
    }

    @Test(groups = {regression}, dataProvider = BAD_PERSONAL_INFO_DP, dataProviderClass = DataProviders.class)
    public void invalidDataTest(String firstName, String lastName, String zipCode, String errorMessage) {
        stepOnePage.fillForm(firstName, lastName, zipCode);
        stepOnePage.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages() {
        stepOnePage = new StepOnePage();
        stepTwoPage = new StepTwoPage();
        cartPage = new CartPage();
    }
}
