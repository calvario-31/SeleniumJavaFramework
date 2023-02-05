package listeners;

import base.BaseListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.Logs;

public class SuiteListeners extends BaseListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        Logs.startSuite(suite.getName());
        fileManager.deleteTestEvidence().redirectStdErr();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }
}
