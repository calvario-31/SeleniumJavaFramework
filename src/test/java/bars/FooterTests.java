package bars;

import base.BaseTest;
import data.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.Footer;
import utilities.CommonFlows;

public class FooterTests extends BaseTest {
    private Footer footer;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        CommonFlows.loginValidUser();
    }

    @Test(groups = {smoke, regression})
    public void verifyFooterTest() {
        footer.verifyPage();
    }

    @Test(groups = {regression})
    public void verifySocialMediaLinksTest() {
        final var socialMediaMap = DataProviders.getSocialMediaMap();
        footer.verifySocialMediaLinks(socialMediaMap);
    }

    @Override
    protected void initPages() {
        footer = new Footer();
    }
}
