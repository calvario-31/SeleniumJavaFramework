package org.complete.framework.bars;

import org.complete.framework.BaseTest;
import org.complete.framework.pageobjects.bars.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends BaseTest {
    private Header header;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {SMOKE})
    public void verifyHeaderTest() {
        header.verifyPage();
    }

    @Override
    protected void initPages() {
        header = new Header(driver);
    }
}
