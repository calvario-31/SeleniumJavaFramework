package org.complete.framework.utilities.listeners;

import org.complete.framework.utilities.DriverManager;
import org.complete.framework.utilities.Logs;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListeners implements ISuiteListener {
    private final Logs log = new Logs();

    @Override
    public void onStart(ISuite suite) {
        log.startSuite(suite.getName());
        new DriverManager().deleteScreenshotFolder();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }
}