package utilities;

import models.CredentialModel;
import models.ItemModel;
import models.PersonalInformationModel;
import models.UrlModel;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.List;

public class DataProviders {
    private final Logs log = new Logs();
    public final static String BAD_PERSONAL_INFO_DP = "bad credentials";

    public CredentialModel getInvalidCredentials() {
        log.debug("Creating invalid credentials");
        var credentialsMap = new MapParsers().getCredentialsMap();
        return credentialsMap.get("locked");
    }

    public String getSauceLabsUrl() {
        log.debug("Creating saucelabs url");
        var urlMap = new MapParsers().getUrlsMap();
        return urlMap.get("saucelabs").getUrl();
    }

    public HashMap<String, UrlModel> getSocialMediaMap() {
        log.debug("Creating social media urls data provider");
        return new MapParsers().getUrlsMap();
    }

    public PersonalInformationModel getPersonalInfo() {
        log.debug("Creating personal info model data provider");
        return new PersonalInformationModel();
    }

    public ItemModel getSingleItem() {
        var itemMap = new MapParsers().getItemsMap();

        log.debug("Returning single item using items map");
        return itemMap.get("bike");
    }

    public CredentialModel getValidCredentials() {
        var credentialsMap = new MapParsers().getCredentialsMap();

        log.debug("Returning valid credentials using credentials map");
        return credentialsMap.get("valid");
    }

    public List<ItemModel> itemsDataProvider() {
        log.debug("Returning all items as a list");
        return new ExcelReader().getItemList();
    }

    @DataProvider(name = BAD_PERSONAL_INFO_DP)
    public Object[][] badPersonalInfoDataProvider() {
        log.debug("Creating bad personal info model data provider");
        var personalInfo = new PersonalInformationModel();
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
}
