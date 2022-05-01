package org.complete.framework.utilities;

import org.complete.framework.models.CredentialModel;
import org.complete.framework.models.ItemModel;
import org.complete.framework.models.UrlModel;

import java.util.HashMap;

public class DataParsers {
    public HashMap<String, CredentialModel> getCredentialsMap() {
        var credentialsList = new ExcelReader().getCredentialsModelList();
        var hashMap = new HashMap<String, CredentialModel>();
        for (CredentialModel credentials : credentialsList) {
            hashMap.put(credentials.getKey(), credentials);
        }
        return hashMap;
    }

    public HashMap<String, UrlModel> getUrlsMap() {
        var urlModelList = new ExcelReader().getUrlModelList();
        var hashMap = new HashMap<String, UrlModel>();
        for (UrlModel url : urlModelList) {
            hashMap.put(url.getKey(), url);
        }
        return hashMap;
    }

    public HashMap<String, ItemModel> getItemsMap() {
        var itemModelList = new ExcelReader().getItemList();
        var hashMap = new HashMap<String, ItemModel>();
        for (ItemModel item : itemModelList) {
            hashMap.put(item.getKey(), item);
        }
        return hashMap;
    }
}
