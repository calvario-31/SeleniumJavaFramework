package data;

import models.Credential;
import models.Item;
import models.PersonalInformation;
import models.Url;
import org.testng.annotations.DataProvider;
import utilities.Logs;

import java.util.HashMap;
import java.util.List;

public class DataProviders {
    public static final String BAD_PERSONAL_INFO_DP = "bad credentials";
    public static final String ITEM_LIST_DP = "item list";

    public static Credential getInvalidCredentials() {
        Logs.debug("Creating invalid credentials");
        final var credentialsMap = MapParsers.getCredentialsMap();
        return credentialsMap.get("locked");
    }

    public static String getSauceLabsUrl() {
        Logs.debug("Creating saucelabs url");
        final var urlMap = MapParsers.getUrlsMap();
        return urlMap.get("saucelabs").getUrl();
    }

    public static HashMap<String, Url> getSocialMediaMap() {
        Logs.debug("Creating social media urls data provider");
        return MapParsers.getUrlsMap();
    }

    public static PersonalInformation getPersonalInfo() {
        Logs.debug("Creating personal info model data provider");
        return new PersonalInformation();
    }

    public static Item getSingleItem() {
        final var itemMap = MapParsers.getItemsMap();

        Logs.debug("Returning single item using items map");
        return itemMap.get("bike");
    }

    public static Credential getValidCredentials() {
        final var credentialsMap = MapParsers.getCredentialsMap();

        Logs.debug("Returning valid credentials using credentials map");
        return credentialsMap.get("valid");
    }

    public static List<Item> itemsDataProvider() {
        Logs.debug("Returning all items as a list");
        return ExcelReader.getItemList();
    }

    @DataProvider(name = BAD_PERSONAL_INFO_DP)
    public static Object[][] badPersonalInfoDataProvider() {
        Logs.debug("Creating bad personal info model data provider");
        final var personalInfo = new PersonalInformation();
        final var errorMessageMap = MapParsers.getErrorMessagesMap();

        final var firstname = personalInfo.getFirstName();
        final var lastname = personalInfo.getLastName();
        final var zipcode = personalInfo.getZipCode();
        final var blank = "";

        final var errorMessageFirstname = errorMessageMap.get("missingFirstname").getErrorMessage();
        final var errorMessageLastName = errorMessageMap.get("missingLastname").getErrorMessage();
        final var errorMessageZipCode = errorMessageMap.get("missingZipcode").getErrorMessage();

        return new Object[][]{
                {blank, lastname, zipcode, errorMessageFirstname},
                {firstname, blank, zipcode, errorMessageLastName},
                {firstname, lastname, blank, errorMessageZipCode}
        };
    }

    @DataProvider(name = ITEM_LIST_DP)
    public static Object[][] itemListDP() {
        Logs.debug("Creating item list data provider");
        final var itemList = ExcelReader.getItemList();
        final var listLength = itemList.size();

        final var object = new Object[listLength][];

        for (var i = 0; i < listLength; i++) {
            final var currentItem = itemList.get(i);
            object[i] =
                    new Object[]{
                            currentItem.getItemName(),
                            currentItem.getPrice(),
                            currentItem.getItemId(),
                            currentItem.getQuantity()
                    };
        }

        return object;
    }
}
