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
    private final Logs log = new Logs();

    public List<Credential> getCredentialsModelList() {
        log.debug("Reading credentials from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), Credential.class);
    }

    public List<Url> getUrlModelList() {
        log.debug("Reading url list from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), Url.class);
    }

    public List<Item> getItemList() {
        log.debug("Reading item list from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), Item.class);
    }

    public List<ErrorMessage> getErrorMessageList() {
        log.debug("Reading error messages from: " + excelPath);
        return Poiji.fromExcel(new File(excelPath), ErrorMessage.class);
    }
}
