package checkout;

import base.BaseTest;
import data.DataProviders;
import models.Item;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.CartPage;
import pageobjects.checkout.StepOnePage;
import pageobjects.checkout.StepTwoPage;

import static data.DataProviders.BAD_PERSONAL_INFO_DP;

public class StepOneTests extends BaseTest {
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;
    private CartPage cartPage;
    private final Item item = dataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.addItemsAndGoToStepOne(item);
    }

    @Test(groups = {smoke})
    public void verifyStepOnePageTest() {
        stepOnePage.verifyPage();
    }

    @Test(groups = {smoke})
    public void validDataTest() {
        var personalInfo = new DataProviders().getPersonalInfo();
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
    protected void initPages(WebDriver driver) {
        stepOnePage = new StepOnePage(driver);
        stepTwoPage = new StepTwoPage(driver);
        cartPage = new CartPage(driver);
    }
}
