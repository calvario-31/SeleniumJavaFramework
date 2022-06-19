package pageobjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import models.UrlModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Footer extends BasePage {
    private final By socialList = By.className("social");
    private final By twitterOption = By.cssSelector(".social_twitter > a");
    private final By facebookOption = By.cssSelector(".social_facebook > a");
    private final By linkedinOption = By.cssSelector(".social_linkedin > a");
    private final By disclaimer = By.className("footer_copy");
    private final By footerImage = By.className("footer_robot");

    public Footer(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting footer to load")
    public void waitPageToLoad() {
        waitPage(socialList, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying footer")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(socialList), "item is displayed");
        softAssert.assertTrue(verifyIsDisplayed(twitterOption), "all items option is displayed");
        softAssert.assertTrue(verifyIsDisplayed(facebookOption), "about option is displayed");
        softAssert.assertTrue(verifyIsDisplayed(linkedinOption), "logout option is displayed");
        softAssert.assertTrue(verifyIsDisplayed(disclaimer), "disclaimer is displayed");
        softAssert.assertTrue(verifyIsDisplayed(footerImage), "footer image is displayed");
        softAssert.assertAll();
    }

    @Step("Verifying social media links")
    public void verifySocialMediaLinks(Map<String, UrlModel> urlMap) {
        var actualTwitterLink = getHref(twitterOption);
        var actualFacebookLink = getHref(facebookOption);
        var actualLinkedinLink = getHref(linkedinOption);

        log.info("Verifying social media links are correct");
        softAssert.assertEquals(actualTwitterLink, urlMap.get("twitter").getUrl(), "twitter link are equals");
        softAssert.assertEquals(actualFacebookLink, urlMap.get("facebook").getUrl(), "fb link are equals");
        softAssert.assertEquals(actualLinkedinLink, urlMap.get("linkedin").getUrl(), "linkedin link are equals");
        softAssert.assertAll();

        log.info("Verifying all options are clickable");
        softAssert.assertTrue(verifyIsClickable(twitterOption), "twitter option is clickable");
        softAssert.assertTrue(verifyIsClickable(facebookOption), "facebook option is clickable");
        softAssert.assertTrue(verifyIsClickable(linkedinOption), "linkedin option is clickable");
        softAssert.assertAll();
    }
}
