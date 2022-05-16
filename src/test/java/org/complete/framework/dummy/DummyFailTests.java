package org.complete.framework.dummy;

import org.complete.framework.pageobjects.checkout.SuccessPage;
import org.complete.framework.utilities.base.BaseTest;
import org.testng.annotations.Test;

public class DummyFailTests extends BaseTest {
    private SuccessPage successPage;

    @Test
    public void verify1Test() {
        commonFlows.verifyFooterHeader();
    }

    @Test
    public void verify2Test() {
        commonFlows.loginValidUser();
        successPage.verifyPage();
    }

    @Override
    protected void initPages() {
        successPage = new SuccessPage(driver);
    }
}
