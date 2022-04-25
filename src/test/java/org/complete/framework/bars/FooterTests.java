package org.complete.framework.bars;

import org.complete.framework.BaseTest;
import org.complete.framework.models.UrlModel;
import org.complete.framework.pageobjects.bars.Footer;
import org.complete.framework.utilities.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.complete.framework.utilities.DataProviders.SOCIAL_MEDIA_URL_DATA_PROVIDER;

public class FooterTests extends BaseTest {
    private Footer footer;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {SMOKE})
    public void verifyFooterTest() {
        footer.verifyPage();
    }

    @Test(groups = {REGRESSION}, dataProvider = SOCIAL_MEDIA_URL_DATA_PROVIDER,
            dataProviderClass = DataProviders.class)
    public void verifySocialMediaLinksTest(Map<String, UrlModel> urlMap) {
        footer.verifySocialMediaLinks(urlMap);
    }

    @Override
    protected void initPages() {
        footer = new Footer(driver);
    }
}
