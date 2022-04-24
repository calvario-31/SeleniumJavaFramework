package org.complete.framework.utilities.reader;

import com.poiji.bind.Poiji;
import org.complete.framework.models.CredentialsModel;
import org.complete.framework.utilities.Logs;

import java.io.File;

public class CredentialsReader {
    private final String EXCEL_PATH = "src/test/resources/data/testData.xlsx";
    private final Logs log = new Logs();

    public CredentialsModel getValidCredentials() {
        log.debug("Reading valid credentials from: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), CredentialsModel.class).get(0);
    }

    public CredentialsModel getLockedCredentials() {
        log.debug("Reading locked credentials from: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), CredentialsModel.class).get(1);
    }

/*    public List<ShoppingItemModel> getItemList() {
        return Poiji.fromExcel(new File(EXCEL_PATH), ShoppingItemModel.class);
    }

    public UserDataModel getUserData() {
        return new UserDataModel();
    }*/
}
