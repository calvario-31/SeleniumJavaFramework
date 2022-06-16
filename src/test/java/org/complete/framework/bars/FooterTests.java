package org.complete.framework.bars;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.Footer;
import utilities.DataProviders;

public class FooterTests extends BaseTest {
    private Footer footer;

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {SMOKE})
    public void verifyFooterTest() {
        footer.verifyPage();
    }

    @Test(groups = {REGRESSION})
    public void verifySocialMediaLinksTest() {
        var socialMediaMap = new DataProviders().getSocialMediaMap();
        footer.verifySocialMediaLinks(socialMediaMap);
    }

    @Override
    protected void initPages() {
        footer = new Footer(driver);
    }
}
