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
    private final Logs log = new Logs();
    public static final String BAD_PERSONAL_INFO_DP = "bad credentials";
    public static final String ITEM_LIST_DP = "item list";

    public Credential getInvalidCredentials() {
        log.debug("Creating invalid credentials");
        var credentialsMap = new MapParsers().getCredentialsMap();
        return credentialsMap.get("locked");
    }

    public String getSauceLabsUrl() {
        log.debug("Creating saucelabs url");
        var urlMap = new MapParsers().getUrlsMap();
        return urlMap.get("saucelabs").getUrl();
    }

    public HashMap<String, Url> getSocialMediaMap() {
        log.debug("Creating social media urls data provider");
        return new MapParsers().getUrlsMap();
    }

    public PersonalInformation getPersonalInfo() {
        log.debug("Creating personal info model data provider");
        return new PersonalInformation();
    }

    public Item getSingleItem() {
        var itemMap = new MapParsers().getItemsMap();

        log.debug("Returning single item using items map");
        return itemMap.get("bike");
    }

    public Credential getValidCredentials() {
        var credentialsMap = new MapParsers().getCredentialsMap();

        log.debug("Returning valid credentials using credentials map");
        return credentialsMap.get("valid");
    }

    public List<Item> itemsDataProvider() {
        log.debug("Returning all items as a list");
        return new ExcelReader().getItemList();
    }

    @DataProvider(name = BAD_PERSONAL_INFO_DP)
    public Object[][] badPersonalInfoDataProvider() {
        log.debug("Creating bad personal info model data provider");
        var personalInfo = new PersonalInformation();
        var errorMessageMap = new MapParsers().getErrorMessagesMap();

        var firstname = personalInfo.getFirstName();
        var lastname = personalInfo.getLastName();
        var zipcode = personalInfo.getZipCode();
        var blank = "";

        var errorMessageFirstname = errorMessageMap.get("missingFirstname").getErrorMessage();
        var errorMessageLastName = errorMessageMap.get("missingLastname").getErrorMessage();
        var errorMessageZipCode = errorMessageMap.get("missingZipcode").getErrorMessage();

        return new Object[][]{
                {blank, lastname, zipcode, errorMessageFirstname},
                {firstname, blank, zipcode, errorMessageLastName},
                {firstname, lastname, blank, errorMessageZipCode}
        };
    }

    @DataProvider(name = ITEM_LIST_DP)
    public Object[][] itemListDP() {
        log.debug("Creating item list data provider");
        var itemList = new ExcelReader().getItemList();
        var listLength = itemList.size();

        var object = new Object[listLength][];

        for (var i = 0; i < listLength; i++) {
            var currentItem = itemList.get(i);
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
