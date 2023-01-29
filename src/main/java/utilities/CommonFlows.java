package utilities;

import data.DataProviders;
import models.Item;
import models.PersonalInformation;
import org.openqa.selenium.WebDriver;
import pageobjects.bars.BurgerMenu;
import pageobjects.bars.Footer;
import pageobjects.bars.Header;
import pageobjects.checkout.CartPage;
import pageobjects.checkout.StepOnePage;
import pageobjects.checkout.StepTwoPage;
import pageobjects.checkout.SuccessPage;
import pageobjects.credentials.LoginPage;
import pageobjects.shopping.HomeShoppingPage;
import pageobjects.shopping.ItemDetailPage;

public class CommonFlows {
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        final var login = new LoginPage(driver);
        login.goToIndex();
        login.waitPageToLoad();
    }

    public void loginValidUser() {
        final var credentials = new DataProviders().getValidCredentials();
        final var login = new LoginPage(driver);
        final var homeShopping = new HomeShoppingPage(driver);
        final var header = new Header(driver);
        final var footer = new Footer(driver);

        login.fillCredentials(credentials.getUsername(), credentials.getPassword());
        homeShopping.waitPageToLoad();
        header.waitPageToLoad();
        footer.waitPageToLoad();
    }

    public void addSingleItemToCart(Item item) {
        final var homeShoppingPage = new HomeShoppingPage(driver);
        final var itemDetailPage = new ItemDetailPage(driver);

        loginValidUser();
        homeShoppingPage.goToItemDetail(item.getItemName());
        itemDetailPage.waitPageToLoad();
        itemDetailPage.verifyCorrectItemDisplay(item.getItemName(), item.getPrice());
        itemDetailPage.verifyPage();
        itemDetailPage.clickingOnAddItemToCart();
        itemDetailPage.clickOnBackToProducts();
        homeShoppingPage.waitPageToLoad();
    }

    public void goToItemDetail(Item item) {
        final var homeShoppingPage = new HomeShoppingPage(driver);
        final var itemDetailPage = new ItemDetailPage(driver);

        loginValidUser();
        homeShoppingPage.goToItemDetail(item.getItemName());
        itemDetailPage.waitPageToLoad();
    }

    public void addItemsToCart() {
        final var listItem = new DataProviders().itemsDataProvider();

        for (Item item : listItem) {
            addSingleItemToCart(item);
        }
    }

    public void openMenuBurger() {
        final var header = new Header(driver);
        final var burgerMenu = new BurgerMenu(driver);

        loginValidUser();
        header.openBurgerMenu();
        burgerMenu.waitPageToLoad();
    }

    public void verifyFooterHeader() {
        final var footer = new Footer(driver);
        final var header = new Header(driver);

        footer.verifyPage();
        header.verifyPage();
    }

    public void addItemsAndGoToCart(Item item) {
        final var cartPage = new CartPage(driver);
        final var header = new Header(driver);

        addSingleItemToCart(item);
        header.clickOnCheckoutCart();
        cartPage.waitPageToLoad();
    }

    public void addItemsAndGoToStepOne(Item item) {
        final var cartPage = new CartPage(driver);
        final var stepOnePage = new StepOnePage(driver);
        addItemsAndGoToCart(item);
        cartPage.clickOnContinueCheckout();
        stepOnePage.waitPageToLoad();
    }

    public void addItemsAndGoToStepTwo(Item item) {
        final var stepOnePage = new StepOnePage(driver);
        final var stepTwoPage = new StepTwoPage(driver);
        final var personalInfo = new PersonalInformation();
        addItemsAndGoToStepOne(item);
        stepOnePage.fillForm(personalInfo.getFirstName(), personalInfo.getLastName(), personalInfo.getZipCode());
        stepTwoPage.waitPageToLoad();
    }

    public void addItemsFinishShopping(Item item) {
        final var stepTwoPage = new StepTwoPage(driver);
        final var successPage = new SuccessPage(driver);

        addItemsAndGoToStepTwo(item);
        stepTwoPage.clickOnFinish();
        successPage.waitPageToLoad();
    }
}
