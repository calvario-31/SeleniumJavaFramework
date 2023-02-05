package fail;

import base.BaseTest;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;
import pageobjects.shopping.ItemDetailPage;

public class FailTests extends BaseTest {
    private SuccessPage successPage;
    private ItemDetailPage itemDetailPage;

    @Test(groups = {smoke, regression})
    public void fail1Test() {
        successPage.verifyPage();
    }

    @Test(groups = {smoke, regression})
    public void fail2Test() {
        itemDetailPage.verifyPage();
    }

    @Override
    protected void initPages() {
        successPage = new SuccessPage();
        itemDetailPage = new ItemDetailPage();
    }
}
