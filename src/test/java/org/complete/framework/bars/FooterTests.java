package org.complete.framework.bars;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.Footer;

public class FooterTests extends BaseTest {
    private Footer footer;

    @BeforeMethod(alwaysRun = true, description = "setup preconditions")
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {smoke})
    public void verifyFooterTest() {
        footer.verifyPage();
    }

    @Test(groups = {regression})
    public void verifySocialMediaLinksTest() {
        var socialMediaMap = new DataProviders().getSocialMediaMap();
        footer.verifySocialMediaLinks(socialMediaMap);
    }

    @Override
    protected void initPages(WebDriver webDriver) {
        footer = new Footer(webDriver);
    }
}
