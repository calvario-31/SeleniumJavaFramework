package data;

import models.Credential;
import models.ErrorMessage;
import models.Item;
import models.Url;
import utilities.Logs;

import java.util.HashMap;

public class MapParsers {

    public HashMap<String, Credential> getCredentialsMap() {
        Logs.debug("Creating credentials map");
        final var credentialsList = new ExcelReader().getCredentialsModelList();
        final var hashMap = new HashMap<String, Credential>();

        for (var credentials : credentialsList) {
            hashMap.put(credentials.getKey(), credentials);
        }
        
        return hashMap;
    }

    public HashMap<String, Url> getUrlsMap() {
        Logs.debug("Creating urls map");
        final var urlModelList = new ExcelReader().getUrlModelList();
        final var hashMap = new HashMap<String, Url>();

        for (var url : urlModelList) {
            hashMap.put(url.getKey(), url);
        }

        return hashMap;
    }

    public HashMap<String, Item> getItemsMap() {
        Logs.debug("Creating items map");
        final var itemModelList = new ExcelReader().getItemList();
        final var hashMap = new HashMap<String, Item>();

        for (var item : itemModelList) {
            hashMap.put(item.getKey(), item);
        }

        return hashMap;
    }

    public HashMap<String, ErrorMessage> getErrorMessagesMap() {
        Logs.debug("Creating errors message map");
        final var itemModelList = new ExcelReader().getErrorMessageList();
        final var hashMap = new HashMap<String, ErrorMessage>();

        for (var errorMessage : itemModelList) {
            hashMap.put(errorMessage.getKey(), errorMessage);
        }

        return hashMap;
    }
}
