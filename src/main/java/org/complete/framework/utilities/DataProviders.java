package org.complete.framework.utilities;

import org.complete.framework.models.CredentialModel;
import org.testng.annotations.DataProvider;

public class DataProviders {
    public final static String SAUCE_LABS_URL_DATA_PROVIDER = "sauce labs data provider";
    public final static String INVALID_CREDENTIALS_DATA_PROVIDER = "invalid credentials";
    public final static String SOCIAL_MEDIA_URL_DATA_PROVIDER = "social media urls";

    @DataProvider(name = INVALID_CREDENTIALS_DATA_PROVIDER)
    private Object[][] invalidCredentialsDataProvider() {
        var credentialsMap = new DataParsers().getCredentialsMap();
        var credentials = credentialsMap.get("locked");
        return new Object[][]{{credentials.getUsername(), credentials.getPassword()}};
    }

    @DataProvider(name = SAUCE_LABS_URL_DATA_PROVIDER)
    public Object[][] sauceLabsUrlDataProvider() {
        var urlMap = new DataParsers().getUrlsMap();
        var url = urlMap.get("saucelabs");
        return new Object[][]{{url.getUrl()}};
    }

    @DataProvider(name = SOCIAL_MEDIA_URL_DATA_PROVIDER)
    public Object[][] socialMediaUrlsDataProvider() {
        var urlMap = new DataParsers().getUrlsMap();
        return new Object[][]{{urlMap}};
    }

    public CredentialModel getValidCredentials() {
        var credentialsMap = new DataParsers().getCredentialsMap();
        return credentialsMap.get("valid");
    }
}
