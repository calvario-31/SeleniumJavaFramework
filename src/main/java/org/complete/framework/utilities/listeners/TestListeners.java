package org.complete.framework.utilities.listeners;

import org.complete.framework.utilities.Logs;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private final Logs log = new Logs();

    @Override
    public void onTestStart(ITestResult result) {
        log.startTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.endTest("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.endTest("FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.endTest("SKIPPED");
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
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
