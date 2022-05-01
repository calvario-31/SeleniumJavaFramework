package org.complete.framework.utilities;

import org.complete.framework.models.CredentialModel;
import org.testng.annotations.DataProvider;

public class DataProviders {
    public final static String SAUCE_LABS_URL_DP = "sauce labs data provider";
    public final static String INVALID_CREDENTIALS_DP = "invalid credentials";
    public final static String SOCIAL_MEDIA_URL_DP = "social media urls";
    public final static String SINGLE_ITEM_DP = "single item";
    public final static String PERSONAL_INFO_DP =  "personal info";

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

    @DataProvider(name = SINGLE_ITEM_DP)
    public Object[][] singleItemDataProvider() {
        var itemMap = new DataParsers().getItemsMap();
        var item = itemMap.get("bike");
        return new Object[][]{{item.getPrice(), item.getItemName(), item.getQuantity()}};
    }

    @DataProvider(name = PERSONAL_INFO_DP)
    public Object[][] personalInfoDataProvider() {
        //TODO
        return null;
    }

    public CredentialModel getValidCredentials() {
        var credentialsMap = new DataParsers().getCredentialsMap();
        return credentialsMap.get("valid");
    }
}
