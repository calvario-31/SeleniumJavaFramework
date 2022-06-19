package utilities;

import com.poiji.bind.Poiji;
import models.CredentialModel;
import models.ErrorMessageModel;
import models.ItemModel;
import models.UrlModel;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String excelPath = "src/test/resources/data/testData.xlsx";
    private final Logs log = new Logs();

    public List<CredentialModel> getCredentialsModelList() {
        log.debug("Reading credentials from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), CredentialModel.class);
    }

    public List<UrlModel> getUrlModelList() {
        log.debug("Reading url list from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), UrlModel.class);
    }

    public List<ItemModel> getItemList() {
        log.debug("Reading item list from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), ItemModel.class);
    }

    public List<ErrorMessageModel> getErrorMessageList() {
        log.debug("Reading error messages from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), ErrorMessageModel.class);
    }
}
