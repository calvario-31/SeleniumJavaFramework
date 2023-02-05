package pageobjects.shopping;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.Logs;
import webelements.list.$$;
import webelements.single.$;

public class HomeShoppingPage extends BasePage {
    private final $ title = $(By.className("title"));
    private final $ filterSelect = $(By.cssSelector("select[data-test='product_sort_container']"));
    private final $$ allPrices = $$(By.className("inventory_item_price"));
    private final $$ allNames = $$(By.className("inventory_item_name"));
    private final $ robotImage = $(By.className("peek"));
    private final $ inventoryContainer = $(By.id("inventory_container"));

    private $ getItemDivByName(String name) {
        final var xpath = String.format("//div[text()='%s']", name);
        return $(By.xpath(xpath));
    }

    public HomeShoppingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting home shopping page to load")
    public void waitPageToLoad() {
        waitPage(inventoryContainer, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying home shopping page")
    public void verifyPage() {
        softAssert.assertTrue(title.isDisplayed(), "title is displayed");
        softAssert.assertTrue(filterSelect.isDisplayed(), "filter select is displayed");
        softAssert.assertTrue(robotImage.isDisplayed(), "robot image is displayed");
        softAssert.assertTrue(inventoryContainer.isDisplayed(), "inventory container is displayed");
        softAssert.assertAll();
    }

    @Step("Filtering by name")
    public void filterByName(boolean isAscendant) {
        if (isAscendant) {
            Logs.info("Filter by name ascendant: AZ");
            filterSelect.selectByValue("az");
        } else {
            Logs.info("Filter by name descendant: ZA");
            filterSelect.selectByValue("za");
        }
    }

    @Step("Filtering by price")
    public void filterByPrice(boolean isAscendant) {
        if (isAscendant) {
            Logs.info("Filter by price ascendant: low -> high");
            filterSelect.selectByValue("lohi");
        } else {
            Logs.info("Filter by price descendant: high -> low");
            filterSelect.selectByValue("hilo");
        }
    }

    @Step("Verifying item price order")
    public void verifyItemPriceOrder(boolean isAscendant) {
        final var firstItem =
                Double.parseDouble(allPrices.getFirst().getText().substring(1));
        final var lastItem =
                Double.parseDouble(allPrices.getLast().getText().substring(1));

        if (isAscendant) {
            Logs.info("Verifying item price order is ascendant: low -> high");
            Assert.assertTrue(firstItem < lastItem);
        } else {
            Logs.info("Verifying item price order is descendant: high -> low");
            Assert.assertTrue(firstItem > lastItem);
        }
    }

    @Step("Verifying item name order")
    public void verifyItemNameOrder(boolean isAscendant) {
        final var firstItem = allNames.getFirst().getText();
        final var lastItem = allNames.getLast().getText();

        if (isAscendant) {
            Logs.info("Verifying item name order is ascendant: AZ");
            Assert.assertTrue(firstItem.compareToIgnoreCase(lastItem) < 0);
        } else {
            Logs.info("Verifying item name order is descendant: ZA");
            Assert.assertTrue(firstItem.compareToIgnoreCase(lastItem) > 0);
        }
    }

    @Step("Going to item detail with name {0}")
    public void goToItemDetail(String itemName) {
        Logs.info("Going to item detail with name %s", itemName);
        getItemDivByName(itemName).click();
    }
}
