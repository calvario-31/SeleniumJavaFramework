package base;

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
    private DriverManager driverManager;
    protected CommonFlows commonFlows;
    protected static final String REGRESSION = "Regression";
    protected static final String SMOKE = "Smoke";

    public WebDriver getDriver() {
        return driver;
    }

    private void initDriver() {
        driverManager = new DriverManager();

        if (runOnServer) {
            driver = driverManager.buildRemoteDriver();
        } else {
            driver = driverManager.buildLocalDriver();
        }

        log.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        log.debug("Maximizing window");
        driver.manage().window().maximize();
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

    protected abstract void initPages(WebDriver webDriver);
}
