package checkout;

import base.BaseTest;
import models.Item;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.StepTwoPage;
import pageobjects.shopping.HomeShoppingPage;

public class StepTwoTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;
    private StepTwoPage stepTwoPage;
    private final Item item = dataProviders.getSingleItem();

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.addItemsAndGoToStepTwo(item);
    }

    @Test(groups = {smoke})
    public void verifyStepTwoTest() {
        stepTwoPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Test(groups = {smoke})
    public void verifyItemContentsTest() {
        stepTwoPage.verifyItemContents(item.getItemName(), item.getPrice());
    }

    @Test(groups = {regression})
    public void verifyReturnToStepOne() {
        stepTwoPage.clickOnCancel();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
        commonFlows.verifyFooterHeader();
    }

    @Override
    protected void initPages(WebDriver webDriver) {
        homeShoppingPage = new HomeShoppingPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
    }
}
