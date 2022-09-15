package data;

import models.Credential;
import models.ErrorMessage;
import models.Item;
import models.Url;
import utilities.Logs;

import java.util.HashMap;

public class MapParsers {
    private final Logs log = new Logs();

    public HashMap<String, Credential> getCredentialsMap() {
        log.debug("Creating credentials map");
        var credentialsList = new ExcelReader().getCredentialsModelList();
        var hashMap = new HashMap<String, Credential>();
        for (var credentials : credentialsList) {
            hashMap.put(credentials.getKey(), credentials);
        }
        return hashMap;
    }

    public HashMap<String, Url> getUrlsMap() {
        log.debug("Creating urls map");
        var urlModelList = new ExcelReader().getUrlModelList();
        var hashMap = new HashMap<String, Url>();
        for (var url : urlModelList) {
            hashMap.put(url.getKey(), url);
        }
        return hashMap;
    }

    public HashMap<String, Item> getItemsMap() {
        log.debug("Creating items map");
        var itemModelList = new ExcelReader().getItemList();
        var hashMap = new HashMap<String, Item>();
        for (var item : itemModelList) {
            hashMap.put(item.getKey(), item);
        }
        return hashMap;
    }

    public HashMap<String, ErrorMessage> getErrorMessagesMap() {
        log.debug("Creating errors message map");
        var itemModelList = new ExcelReader().getErrorMessageList();
        var hashMap = new HashMap<String, ErrorMessage>();
        for (var errorMessage : itemModelList) {
            hashMap.put(errorMessage.getKey(), errorMessage);
        }
        return hashMap;
    }
}
