package org.complete.framework.utilities;

import org.complete.framework.models.CredentialModel;
import org.complete.framework.models.ItemModel;
import org.complete.framework.models.PersonalInformationModel;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviders {
    public final static String SAUCE_LABS_URL_DP = "sauce labs data provider";
    public final static String INVALID_CREDENTIALS_DP = "invalid credentials";
    public final static String SOCIAL_MEDIA_URL_DP = "social media urls";
    public final static String PERSONAL_INFO_DP = "personal info";
    public final static String BAD_PERSONAL_INFO_DP = "bad credentials";

    @DataProvider(name = INVALID_CREDENTIALS_DP)
    private Object[][] invalidCredentialsDataProvider() {
        var credentialsMap = new DataParsers().getCredentialsMap();
        var credentials = credentialsMap.get("locked");
        return new Object[][]{{credentials.getUsername(), credentials.getPassword()}};
    }

    @DataProvider(name = SAUCE_LABS_URL_DP)
    public Object[][] sauceLabsUrlDataProvider() {
        var urlMap = new DataParsers().getUrlsMap();
        var url = urlMap.get("saucelabs");
        return new Object[][]{{url.getUrl()}};
    }

    @DataProvider(name = SOCIAL_MEDIA_URL_DP)
    public Object[][] socialMediaUrlsDataProvider() {
        var urlMap = new DataParsers().getUrlsMap();
        return new Object[][]{{urlMap}};
    }

    @DataProvider(name = PERSONAL_INFO_DP)
    public Object[][] personalInfoDataProvider() {
        var personalInfo = new PersonalInformationModel();
        return new Object[][]{{personalInfo.getFirstName(), personalInfo.getLastName(), personalInfo.getZipCode()}};
    }

    @DataProvider(name = BAD_PERSONAL_INFO_DP)
    public Object[][] badPersonalInfoDataProvider() {
        var personalInfo = new PersonalInformationModel();
        var errorMessageMap = new DataParsers().getErrorMessageMap();

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

    public ItemModel getSingleItem() {
        var itemMap = new DataParsers().getItemsMap();
        return itemMap.get("bike");
    }

    public CredentialModel getValidCredentials() {
        var credentialsMap = new DataParsers().getCredentialsMap();
        return credentialsMap.get("valid");
    }

    public List<ItemModel> itemsDataProvider() {
        return new ExcelReader().getItemList();
    }
}
