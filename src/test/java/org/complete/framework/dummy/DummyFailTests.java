package org.complete.framework.dummy;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.checkout.SuccessPage;

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
    protected void initPages(WebDriver driver) {
        successPage = new SuccessPage(driver);
    }
}
