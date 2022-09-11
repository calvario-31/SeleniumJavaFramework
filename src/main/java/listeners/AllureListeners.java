package listeners;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import utilities.DriverManager;

public class AllureListeners implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus().name().equalsIgnoreCase("FAILED")) {
            DriverManager.getAllureScreenshot();
        }
    }
}
