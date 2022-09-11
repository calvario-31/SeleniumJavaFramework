package pageobjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import models.UrlModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

import java.util.Map;

public class Footer extends BasePage {
    private final $ socialList = $(By.className("social"));
    private final $ twitterOption = $(By.cssSelector(".social_twitter > a"));
    private final $ facebookOption = $(By.cssSelector(".social_facebook > a"));
    private final $ linkedinOption = $(By.cssSelector(".social_linkedin > a"));
    private final $ disclaimer = $(By.className("footer_copy"));
    private final $ footerImage = $(By.className("footer_robot"));

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
        softAssert.assertTrue(socialList.isDisplayed(), "item is displayed");
        softAssert.assertTrue(twitterOption.isDisplayed(), "all items option is displayed");
        softAssert.assertTrue(facebookOption.isDisplayed(), "about option is displayed");
        softAssert.assertTrue(linkedinOption.isDisplayed(), "logout option is displayed");
        softAssert.assertTrue(disclaimer.isDisplayed(), "disclaimer is displayed");
        softAssert.assertTrue(footerImage.isDisplayed(), "footer image is displayed");
        softAssert.assertAll();
    }

    @Step("Verifying social media links")
    public void verifySocialMediaLinks(Map<String, UrlModel> urlMap) {
        log.info("Verifying social media links are correct");
        softAssert.assertEquals(twitterOption.getHref(), urlMap.get("twitter").getUrl(), "twitter link are equals");
        softAssert.assertEquals(facebookOption.getHref(), urlMap.get("facebook").getUrl(), "fb link are equals");
        softAssert.assertEquals(linkedinOption.getHref(), urlMap.get("linkedin").getUrl(), "linkedin link are equals");
        softAssert.assertTrue(twitterOption.isEnabled(), "twitter option is clickable");
        softAssert.assertTrue(facebookOption.isEnabled(), "facebook option is clickable");
        softAssert.assertTrue(linkedinOption.isEnabled(), "linkedin option is clickable");
        softAssert.assertAll();
    }
}
