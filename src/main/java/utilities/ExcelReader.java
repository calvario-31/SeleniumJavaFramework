package utilities;

import com.poiji.bind.Poiji;
import models.CredentialModel;
import models.ErrorMessageModel;
import models.ItemModel;
import models.UrlModel;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String EXCEL_PATH = "src/test/resources/data/testData.xlsx";
    private final Logs log = new Logs();

    public List<CredentialModel> getCredentialsModelList() {
        log.debug("Reading credentials from: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), CredentialModel.class);
    }

    public List<UrlModel> getUrlModelList() {
        log.debug("Reading url list from: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), UrlModel.class);
    }

    public List<ItemModel> getItemList() {
        log.debug("Reading item list from: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), ItemModel.class);
    }

    public List<ErrorMessageModel> getErrorMessageList() {
        log.debug("Reading error messages from: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), ErrorMessageModel.class);
    }
}
