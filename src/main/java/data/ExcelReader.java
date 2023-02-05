package data;

import com.poiji.bind.Poiji;
import models.Credential;
import models.ErrorMessage;
import models.Item;
import models.Url;
import utilities.Logs;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String excelPath = "src/test/resources/data/testData.xlsx";

    public List<Credential> getCredentialsModelList() {
        Logs.debug("Reading credentials from: %s", excelPath);
        return Poiji.fromExcel(new File(excelPath), Credential.class);
    }

    public List<Url> getUrlModelList() {
        Logs.debug("Reading url list from: %s", excelPath);
        return Poiji.fromExcel(new File(excelPath), Url.class);
    }

    public List<Item> getItemList() {
        Logs.debug("Reading item list from: %s", excelPath);
        return Poiji.fromExcel(new File(excelPath), Item.class);
    }

    public List<ErrorMessage> getErrorMessageList() {
        Logs.debug("Reading error messages from: %s", excelPath);
        return Poiji.fromExcel(new File(excelPath), ErrorMessage.class);
    }
}
