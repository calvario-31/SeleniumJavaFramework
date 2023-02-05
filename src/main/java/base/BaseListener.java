package base;

import utilities.Logs;

public abstract class BaseListener {

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
