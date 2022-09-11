package pageobjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webelements.single.$;

public class BurgerMenu extends BasePage {
    private final $ itemList = $(By.className("bm-item-list"));
    private final $ allItemsOption = $(By.id("inventory_sidebar_link"));
    private final $ aboutOption = $(By.id("about_sidebar_link"));
    private final $ logoutOption = $(By.id("logout_sidebar_link"));

    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting menu burger to load")
    public void waitPageToLoad() {
        waitPage(itemList, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying burger menu page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(itemList.isDisplayed(), "item is displayed");
        softAssert.assertTrue(allItemsOption.isDisplayed(), "all items option is displayed");
        softAssert.assertTrue(aboutOption.isDisplayed(), "about option is displayed");
        softAssert.assertTrue(logoutOption.isDisplayed(), "logout option is displayed");
        softAssert.assertAll();
    }

    @Step("Verifying about link")
    public void verifyAboutLink(String expectedLink) {
        softAssert.assertEquals(aboutOption.getHref(), expectedLink);
        softAssert.assertTrue(aboutOption.isEnabled());
        softAssert.assertAll();
    }

    @Step("Clicking on logout option")
    public void clickOnLogout() {
        log.info("Clicking on logout option");
        logoutOption.click();
    }

    @Step("Clicking on all items option")
    public void clickOnAllItems() {
        log.info("Clicking on all items option");
        allItemsOption.click();
    }
}
