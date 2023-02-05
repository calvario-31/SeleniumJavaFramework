package base;

import listeners.InvokeMethodListeners;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.CommonFlows;
import utilities.DriverFactory;
import utilities.Logs;

@Listeners({TestListeners.class, SuiteListeners.class, InvokeMethodListeners.class})
public abstract class BaseTest {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";
    protected final String setup = "Setup";

    private void initDriver() {
        threadLocalDriver.set(DriverFactory.createDriver());
    }

    @BeforeMethod(alwaysRun = true, description = "setting up the driver and going to index")
    protected void setupDriver() {
        initDriver();
        initPages();

        Logs.debug("Maximizing window");
        getDriver().manage().window().maximize();

        Logs.debug("Deleting cookies");
        getDriver().manage().deleteAllCookies();

        CommonFlows.goToIndex();
    }

    @AfterMethod(alwaysRun = true, description = "killing the driver")
    protected void teardownDriver() {
        Logs.debug("Killing the driver");
        getDriver().quit();
        threadLocalDriver.remove();
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    protected abstract void initPages();
}
