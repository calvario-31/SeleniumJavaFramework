package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;

public class DriverManager {
    protected final Logs log = new Logs();
    private final String screenshotPath = "src/test/resources/screenshots";
    private final Logs logs = new Logs();
    private String browserName;
    private Boolean headlessMode = true;
    protected WebDriver driver;
    private static WebDriver staticDriver;

    public WebDriver buildLocalDriver() {
        browserName = System.getProperty("browser");
        var headlessString = System.getProperty("headlessMode");

        if (browserName == null) {
            logs.debug("Setting default local browser to CHROME");
            browserName = "CHROME";
        }

        if (headlessString == null) { //headless string is not passed then is false
            logs.debug("Setting headless mode OFF");
            headlessMode = false;
        }

        log.debug("Initializing the driver");
        switch (browserName) {
            case "CHROME":
                log.debug("Chrome driver");
                WebDriverManager.chromedriver().setup();
                var chromeOptions = new ChromeOptions().setHeadless(headlessMode);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "EDGE":
                log.debug("Edge driver");
                WebDriverManager.edgedriver().setup();
                var edgeOptions = new EdgeOptions().setHeadless(headlessMode);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                log.error("Bad driver name");
                driver = null;
        }

        log.debug("Maximizing window");
        driver.manage().window().maximize();

        log.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        staticDriver = driver;

        return driver;
    }

    public WebDriver buildRemoteDriver() {
        //TODO
        return null;
    }

    public void getScreenshot(WebDriver driver, String screenshotName) {
        logs.debug("Taking screenshot");
        var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        var path = String.format("%s/%s.png", screenshotPath, screenshotName);
        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            logs.error("Failed creating screenshot");
            logs.error(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "Screenshot failure", type = "image/png")
    public static byte[] getAllureScreenshot() {
        return ((TakesScreenshot) staticDriver).getScreenshotAs(OutputType.BYTES);
    }

    public void deleteScreenshotsFolder() {
        try {
            logs.debug("Deleting screenshots directory");
            FileUtils.deleteDirectory(new File(screenshotPath));
        } catch (IOException ioException) {
            logs.error("Failed deleting screenshots folder");
            logs.error(ioException.getLocalizedMessage());
        }
    }
}
