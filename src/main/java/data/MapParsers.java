package data;

import models.Credential;
import models.ErrorMessage;
import models.Item;
import models.Url;
import utilities.Logs;

import java.util.HashMap;

public class MapParsers {

    public static HashMap<String, Credential> getCredentialsMap() {
        Logs.debug("Creating credentials map");
        final var credentialsList = ExcelReader.getCredentialsModelList();
        final var hashMap = new HashMap<String, Credential>();

        for (var element : credentialsList) {
            hashMap.put(element.getKey(), element);
        }

        return hashMap;
    }

    public static HashMap<String, Url> getUrlsMap() {
        Logs.debug("Creating urls map");
        final var urlModelList = ExcelReader.getUrlModelList();
        final var hashMap = new HashMap<String, Url>();

        for (var element : urlModelList) {
            hashMap.put(element.getKey(), element);
        }

        return hashMap;
    }

    public static HashMap<String, Item> getItemsMap() {
        Logs.debug("Creating items map");
        final var itemModelList = ExcelReader.getItemList();
        final var hashMap = new HashMap<String, Item>();

        for (var element : itemModelList) {
            hashMap.put(element.getKey(), element);
        }

        return hashMap;
    }

    public static HashMap<String, ErrorMessage> getErrorMessagesMap() {
        Logs.debug("Creating errors message map");
        final var itemModelList = ExcelReader.getErrorMessageList();
        final var hashMap = new HashMap<String, ErrorMessage>();

        for (var element : itemModelList) {
            hashMap.put(element.getKey(), element);
        }

        return hashMap;
    }
}
