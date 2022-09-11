package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("errorMessages")
public class ErrorMessage {
    @ExcelCellName("key")
    private String key;
    @ExcelCellName("errorMessage")
    private String errorMessage;

    public String getKey() {
        return key;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
