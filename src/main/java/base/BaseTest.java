package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.CommonFlows;
import utilities.DriverManager;
import utilities.listeners.SuiteListeners;
import utilities.listeners.TestListeners;

@Listeners({TestListeners.class, SuiteListeners.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected CommonFlows commonFlows;
    protected static final String REGRESSION = "Regression";
    protected static final String SMOKE = "Smoke";
    private final boolean runOnServer = System.getenv("JOB_NAME") != null;
    private DriverManager driverManager;

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

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        commonFlows = new CommonFlows(driver);
    }

    @BeforeMethod(alwaysRun = true, description = "setting up the driver and going to index")
    protected void setupDriver() {
        initDriver();
        initPages();
        commonFlows.goToIndex();
    }

    @AfterMethod(alwaysRun = true, description = "killing the driver")
    protected void teardownDriver() {
        driver.quit();
    }

    protected abstract void initPages();
}