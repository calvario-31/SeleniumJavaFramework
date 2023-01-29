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
    private String browserName;
    private Boolean headlessMode = true;
    protected WebDriver driver;

    public WebDriver buildLocalDriver() {
        browserName = System.getProperty("browser");
        final var headlessString = System.getProperty("headlessMode");

        if (browserName == null) {
            Logs.debug("Setting default local browser to CHROME");
            browserName = "CHROME";
        }

        if (headlessString == null) { //headless string is not passed then is false
            Logs.debug("Setting headless mode OFF");
            headlessMode = false;
        }

        Logs.debug("Initializing the driver");

        switch (browserName) {
            case "CHROME":
                Logs.debug("Chrome driver");
                WebDriverManager.chromedriver().setup();
                final var chromeOptions = new ChromeOptions().setHeadless(headlessMode);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "EDGE":
                Logs.debug("Edge driver");
                WebDriverManager.edgedriver().setup();
                final var edgeOptions = new EdgeOptions().setHeadless(headlessMode);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "FIREFOX":
                Logs.debug("Firefox driver");
                WebDriverManager.firefoxdriver().setup();
                final var firefoxOptions = new FirefoxOptions().setHeadless(headlessMode);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                Logs.error("Bad driver name");
                driver = null;
        }

        assert driver != null;
        ((RemoteWebDriver) driver).setLogLevel(Level.OFF);

        Logs.debug("Maximizing window");
        driver.manage().window().maximize();

        Logs.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        FileManager.staticDriver = driver;

        return driver;
    }

    public WebDriver buildRemoteDriver() {
        //TODO
        return null;
    }
}
