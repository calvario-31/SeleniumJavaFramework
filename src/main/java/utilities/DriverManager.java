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
import org.openqa.selenium.safari.SafariDriver;

import java.util.logging.Level;

import static utilities.DriverManager.Browser.CHROME;

public class DriverManager {
    private Browser browser;
    private Boolean headlessMode = true;
    protected WebDriver driver;

    public WebDriver buildLocalDriver() {
        final var browserProperty = System.getProperty("browser");
        final var headlessString = System.getProperty("headlessMode");

        if (browserProperty == null) {
            Logs.debug("Setting default local browser to CHROME");
            browser = CHROME;
        } else {
            browser = Browser.valueOf(browserProperty);
        }

        if (headlessString == null) { //headless string is not passed then is false
            Logs.debug("Setting headless mode OFF");
            headlessMode = false;
        }

        Logs.debug("Initializing the driver");

        switch (browser) {
            case CHROME:
                Logs.debug("Chrome driver");
                WebDriverManager.chromedriver().setup();
                final var chromeOptions = new ChromeOptions().setHeadless(headlessMode);
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                Logs.debug("Edge driver");
                WebDriverManager.edgedriver().setup();
                final var edgeOptions = new EdgeOptions().setHeadless(headlessMode);
                driver = new EdgeDriver(edgeOptions);
                break;
            case FIREFOX:
                Logs.debug("Firefox driver");
                WebDriverManager.firefoxdriver().setup();
                final var firefoxOptions = new FirefoxOptions().setHeadless(headlessMode);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case SAFARI:
                Logs.debug("Safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver(); //does not support headless mode
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

    public enum Browser {
        CHROME("CHROME"),
        EDGE("EDGE"),
        SAFARI("SAFARI"),
        FIREFOX("FIREFOX");

        public final String browserName;

        Browser(String browserName) {
            this.browserName = browserName;
        }
    }
}
