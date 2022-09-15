package base;

import data.DataProviders;
import listeners.InvokeMethodListeners;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.CommonFlows;
import utilities.DriverManager;
import utilities.Logs;

@Listeners({TestListeners.class, SuiteListeners.class, InvokeMethodListeners.class})
public abstract class BaseTest {
    private final boolean runOnServer = System.getenv("JOB_NAME") != null;
    private final Logs log = new Logs();
    private WebDriver driver;
    protected CommonFlows commonFlows;
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";
    protected final DataProviders dataProviders = new DataProviders();

    private void initDriver() {
        var driverManager = new DriverManager();

        if (runOnServer) {
            driver = driverManager.buildRemoteDriver();
        } else {
            driver = driverManager.buildLocalDriver();
        }
    }

    @BeforeMethod(alwaysRun = true, description = "setting up the driver and going to index")
    protected void setupDriver() {
        initDriver();
        commonFlows = new CommonFlows(driver);

        initPages(driver);
        commonFlows.goToIndex();
    }

    @AfterMethod(alwaysRun = true, description = "killing the driver")
    protected void teardownDriver() {
        log.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void initPages(WebDriver webDriver);
}
