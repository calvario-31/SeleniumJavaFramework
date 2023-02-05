package listeners;

import base.BaseListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import utilities.FileManager;
import utilities.Logs;

public class AllureListeners extends BaseListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        Logs.debug("beforeTestStop: %s", result.getStatus().name());

        if (result.getStatus().name().equalsIgnoreCase("FAILED") ||
                result.getStatus().name().equalsIgnoreCase("BROKEN")) {
            Logs.debug("failed");
            FileManager.takeAllureScreenshot();
        }
    }
}
