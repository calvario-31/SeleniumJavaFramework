package listeners;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.DriverManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    private final Logs log = new Logs();

    @Override
    public void onTestStart(ITestResult result) {
        log.testSteps();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.endTest("PASSED");
        System.out.println("\t" + result.getInstanceName() + "." + result.getName() + "... \u001B[32mPASSED\u001B[0m");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.endTest("FAILED");
        System.out.println("\t" + result.getInstanceName() + "." + result.getName() + "... \u001B[31mFAILED\u001B[0m");
        var driver = getDriverFromResult(result);
        var driverManager = new DriverManager();
        driverManager.getScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.endTest("SKIPPED");
        System.out.println("\t" + result.getInstanceName() + "." + result.getName() + "... \u001B[33mSKIPPED\u001B[0m");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println();
    }

    private WebDriver getDriverFromResult(ITestResult result) {
        var currentClass = result.getInstance();
        return ((BaseTest) currentClass).getDriver();
    }
}
