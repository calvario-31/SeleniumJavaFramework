package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("urls")
public class Url {
    @ExcelCellName("key")
    private String key;

    @ExcelCellName("url")
    private String url;

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }
}
