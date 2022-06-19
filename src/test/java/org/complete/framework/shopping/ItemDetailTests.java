package org.complete.framework.shopping;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemDetailTests extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {SMOKE})
    public void verifyItemDetailTest() {
        var item = new DataProviders().getSingleItem();
        commonFlows.addSingleItemToCart(item);
    }

    @Override
    protected void initPages(WebDriver driver) {
    }
}
