package org.complete.framework.shopping;

import org.complete.framework.utilities.base.BaseTest;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemDetailTests extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test (groups = {SMOKE})
    public void verifyItemDetailTest() {
        var item = new DataProviders().getSingleItem();
        commonFlows.addSingleItemToCart(item);
    }

    @Override
    protected void initPages() {
    }
}
