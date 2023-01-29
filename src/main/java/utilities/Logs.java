package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private static final Logger log = LogManager.getLogger("AUTOMATION");
    private static final String bigSeparator =
            "------------------------------------------------------------------------------------------";
    private static final String smallSeparator = "**********************************************************";

    private static void printTestSeparator() {
        log.info(bigSeparator);
    }

    private static void printSeparator() {
        log.info(smallSeparator);
    }

    private static void printSeparatorDebug() {
        log.debug(smallSeparator);
    }

    private static void printNewLine() {
        log.info("");
    }

    public static void startTest(String testName) {
        printTestSeparator();
        log.info("Test: " + testName);
        printTestSeparator();
    }

    public static void endTest(String status) {
        printTestSeparator();
        log.info(status);
        printTestSeparator();
        printNewLine();
        printNewLine();
    }

    public static void startSuite(String suiteName) {
        printNewLine();
        printTestSeparator();
        printTestSeparator();
        log.info("Suite: " + suiteName);
        printTestSeparator();
        printTestSeparator();
        printNewLine();
    }

    public static void preconditionStart() {
        printSeparator();
        log.info("SETUP");
        printSeparator();
    }

    public static void postConditionStart() {
        printSeparatorDebug();
        log.debug("TEARDOWN");
        printSeparatorDebug();
    }

    public static void postConditionFinish() {
        printSeparatorDebug();
    }

    public static void testSteps() {
        printSeparator();
        log.info("TEST");
        printSeparator();
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }
}
