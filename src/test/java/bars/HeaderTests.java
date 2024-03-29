package bars;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.Header;

public class HeaderTests extends BaseTest {
    private Header header;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {smoke})
    public void verifyHeaderTest() {
        header.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        header = new Header(driver);
    }
}
