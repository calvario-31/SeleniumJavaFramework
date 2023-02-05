package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public abstract class BaseListener {
    protected WebDriver driver;
    protected static WebDriver staticDriver;
    protected final FileManager fileManager = new FileManager();

    protected void setDriver(ITestResult result) {
        final var currentClass = result.getInstance();
        driver = ((BaseTest) currentClass).getDriver(); //for the test listeners
    }

    protected void printSuccess(String className, String testName) {
        final var status = "PASSED";
        Logs.endTest(status);
        final var message =
                String.format("\t %s.%s ... \u001B[32m%s\u001B[0m", className, testName, status);
        System.out.println(message);
    }

    protected void printFailed(String className, String testName) {
        final var status = "FAILED";
        Logs.endTest(status);
        final var message =
                String.format("\t %s.%s ... \u001B[31m%s\u001B[0m", className, testName, status);
        System.out.println(message);
    }

    protected void printSkipped(String className, String testName) {
        final var status = "SKIPPED";
        Logs.endTest(status);
        final var message =
                String.format("\t %s.%s ... \u001B[33m%s\u001B[0m", className, testName, status);
        System.out.println(message);
    }
}
