package bars;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.Header;
import utilities.CommonFlows;

public class HeaderTests extends BaseTest {
    private Header header;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.loginValidUser();
    }

    @Test(groups = {smoke, regression})
    public void verifyHeaderTest() {
        header.verifyPage();
    }

    @Override
    protected void initPages() {
        header = new Header();
    }
}
