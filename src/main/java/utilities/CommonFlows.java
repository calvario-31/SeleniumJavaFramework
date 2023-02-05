package utilities;

import data.DataProviders;
import models.Item;
import models.PersonalInformation;
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

    public static void goToIndex() {
        final var login = new LoginPage();

        login.goToIndex();
        login.waitPageToLoad();
    }

    public static void loginValidUser() {
        final var credentials = DataProviders.getValidCredentials();
        final var login = new LoginPage();
        final var homeShopping = new HomeShoppingPage();
        final var header = new Header();
        final var footer = new Footer();

        login.fillCredentials(credentials.getUsername(), credentials.getPassword());
        homeShopping.waitPageToLoad();
        header.waitPageToLoad();
        footer.waitPageToLoad();
    }

    public static void addSingleItemToCart(Item item) {
        final var homeShoppingPage = new HomeShoppingPage();
        final var itemDetailPage = new ItemDetailPage();

        loginValidUser();
        homeShoppingPage.goToItemDetail(item.getItemName());
        itemDetailPage.waitPageToLoad();
        itemDetailPage.verifyCorrectItemDisplay(item.getItemName(), item.getPrice());
        itemDetailPage.verifyPage();
        itemDetailPage.clickingOnAddItemToCart();
        itemDetailPage.clickOnBackToProducts();
        homeShoppingPage.waitPageToLoad();
    }

    public static void goToItemDetail(Item item) {
        final var homeShoppingPage = new HomeShoppingPage();
        final var itemDetailPage = new ItemDetailPage();

        loginValidUser();
        homeShoppingPage.goToItemDetail(item.getItemName());
        itemDetailPage.waitPageToLoad();
    }

    public static void addItemsToCart() {
        final var listItem = DataProviders.itemsDataProvider();

        for (Item item : listItem) {
            addSingleItemToCart(item);
        }
    }

    public static void openMenuBurger() {
        final var header = new Header();
        final var burgerMenu = new BurgerMenu();

        loginValidUser();
        header.openBurgerMenu();
        burgerMenu.waitPageToLoad();
    }

    public static void verifyFooterHeader() {
        final var footer = new Footer();
        final var header = new Header();

        footer.verifyPage();
        header.verifyPage();
    }

    public static void addItemsAndGoToCart(Item item) {
        final var cartPage = new CartPage();
        final var header = new Header();

        addSingleItemToCart(item);
        header.clickOnCheckoutCart();
        cartPage.waitPageToLoad();
    }

    public static void addItemsAndGoToStepOne(Item item) {
        final var cartPage = new CartPage();
        final var stepOnePage = new StepOnePage();

        addItemsAndGoToCart(item);
        cartPage.clickOnContinueCheckout();
        stepOnePage.waitPageToLoad();
    }

    public static void addItemsAndGoToStepTwo(Item item) {
        final var stepOnePage = new StepOnePage();
        final var stepTwoPage = new StepTwoPage();
        final var personalInfo = new PersonalInformation();

        addItemsAndGoToStepOne(item);
        stepOnePage.fillForm(personalInfo.getFirstName(), personalInfo.getLastName(),
                personalInfo.getZipCode());
        stepTwoPage.waitPageToLoad();
    }

    public static void addItemsFinishShopping(Item item) {
        final var stepTwoPage = new StepTwoPage();
        final var successPage = new SuccessPage();

        addItemsAndGoToStepTwo(item);
        stepTwoPage.clickOnFinish();
        successPage.waitPageToLoad();
    }
}
