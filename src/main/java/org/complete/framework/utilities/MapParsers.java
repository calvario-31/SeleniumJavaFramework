package org.complete.framework.utilities;

import org.complete.framework.models.CredentialModel;
import org.complete.framework.models.ErrorMessageModel;
import org.complete.framework.models.ItemModel;
import org.complete.framework.models.UrlModel;

import java.util.HashMap;

public class MapParsers {
    private final Logs log = new Logs();

    public HashMap<String, CredentialModel> getCredentialsMap() {
        log.debug("Creating credentials map");
        var credentialsList = new ExcelReader().getCredentialsModelList();
        var hashMap = new HashMap<String, CredentialModel>();
        for (CredentialModel credentials : credentialsList) {
            hashMap.put(credentials.getKey(), credentials);
        }
        return hashMap;
    }

    public HashMap<String, UrlModel> getUrlsMap() {
        log.debug("Creating urls map");
        var urlModelList = new ExcelReader().getUrlModelList();
        var hashMap = new HashMap<String, UrlModel>();
        for (UrlModel url : urlModelList) {
            hashMap.put(url.getKey(), url);
        }
        return hashMap;
    }

    public HashMap<String, ItemModel> getItemsMap() {
        log.debug("Creating items map");
        var itemModelList = new ExcelReader().getItemList();
        var hashMap = new HashMap<String, ItemModel>();
        for (ItemModel item : itemModelList) {
            hashMap.put(item.getKey(), item);
        }
        return hashMap;
    }

    public HashMap<String, ErrorMessageModel> getErrorMessagesMap() {
        log.debug("Creating errors message map");
        var itemModelList = new ExcelReader().getErrorMessageList();
        var hashMap = new HashMap<String, ErrorMessageModel>();
        for (ErrorMessageModel errorMessage : itemModelList) {
            hashMap.put(errorMessage.getKey(), errorMessage);
        }
        return hashMap;
    }
}
