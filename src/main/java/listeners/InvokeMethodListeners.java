package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilities.Logs;

public class InvokeMethodListeners implements IInvokedMethodListener {
    private final Logs log = new Logs();
    private final String preConditionMethodName = "setupDriver";
    private final String postConditionMethodName = "teardownDriver";

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.getTestResult().getName().equals(preConditionMethodName)) {
            log.startTest(testResult.getInstanceName());
            log.preconditionStart();
        }

        if (method.getTestResult().getName().equals(postConditionMethodName)) {
            log.postConditionStart();
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.getTestResult().getName().equals(postConditionMethodName)) {
            log.postConditionFinish();
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult, context);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        IInvokedMethodListener.super.afterInvocation(method, testResult, context);
    }
}
