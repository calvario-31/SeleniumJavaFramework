package listeners;

import base.BaseListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class AllureListeners extends BaseListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        logs.debug("beforeTestStop: " + result.getStatus().name());

        if (result.getStatus().name().equalsIgnoreCase("FAILED") ||
                result.getStatus().name().equalsIgnoreCase("BROKEN")) {
            logs.debug("failed");
            fileManager.getAllureScreenshot(staticDriver);
        }
    }
}
