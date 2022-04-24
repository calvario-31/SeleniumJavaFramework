package org.complete.framework.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private final Logs logs = new Logs();
    private String browserName;

    public WebDriver buildLocalDriver() {
        browserName = System.getProperty("browser");

        if (browserName == null) {
            logs.info("Setting default local browser to CHROME");
            browserName = "CHROME";
        }

        switch (browserName) {
            case "CHROME":
                logs.debug("Starting chrome driver");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "EDGE":
                logs.debug("Starting edge driver");
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                logs.debug(browserName + " not supported");
                return null;
        }
    }

    public WebDriver buildRemoteDriver() {
        //TODO
        return null;
    }
}
