package fail;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;

public class FailTests extends BaseTest {
    private SuccessPage successPage;

    @Test
    public void fail1Test() {
        successPage.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        successPage = new SuccessPage(driver);
    }
}
