package utilities.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.DriverManager;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    private final Logs log = new Logs();

    @Override
    public void onStart(ISuite suite) {
        log.startSuite(suite.getName());
        new DriverManager().deleteScreenshotsFolder();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }
}
