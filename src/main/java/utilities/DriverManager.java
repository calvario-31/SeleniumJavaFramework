package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Level;

public class DriverManager {
    private final Logs logs = new Logs();
    private String browserName;
    private Boolean headlessMode = true;
    protected WebDriver driver;

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

        logs.debug("Initializing the driver");

        switch (browserName) {
            case "CHROME":
                logs.debug("Chrome driver");
                WebDriverManager.chromedriver().setup();
                var chromeOptions = new ChromeOptions().setHeadless(headlessMode);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "EDGE":
                logs.debug("Edge driver");
                WebDriverManager.edgedriver().setup();
                var edgeOptions = new EdgeOptions().setHeadless(headlessMode);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "FIREFOX":
                logs.debug("Firefox driver");
                WebDriverManager.firefoxdriver().setup();
                var firefoxOptions = new FirefoxOptions().setHeadless(headlessMode);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                logs.error("Bad driver name");
                driver = null;
        }

        assert driver != null;
        ((RemoteWebDriver) driver).setLogLevel(Level.OFF);

        logs.debug("Maximizing window");
        driver.manage().window().maximize();

        logs.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        FileManager.staticDriver = driver;

        return driver;
    }

    public WebDriver buildRemoteDriver() {
        //TODO
        return null;
    }
}
