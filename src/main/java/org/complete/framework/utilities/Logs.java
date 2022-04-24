package org.complete.framework.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private final Logger log;

    private void printSeparator() {
        log.info("------------------------------------------------------------------------------------------");
    }

    private void printNewLine() {
        log.info("");
    }

    public Logs() {
        log = LogManager.getLogger("AUTOMATION");
    }

    public void startTest(String testName) {
        System.out.println();
        printSeparator();
        log.info("Test: " + testName);
        printSeparator();
        System.out.print(testName);
    }

    public void endTest(String status) {
        printSeparator();
        log.info(status);
        printSeparator();
        System.out.println("\t" + status);
        System.out.println();
        printNewLine();
        printNewLine();
    }

    public void startSuite(String suiteName) {
        printNewLine();
        printSeparator();
        printSeparator();
        log.info("Beginning: " + suiteName);
        printSeparator();
        printSeparator();
        printNewLine();
    }

    public void info(String message) {
        log.info(message);
    }

    public void warn(String message) {
        log.warn(message);
    }

    public void error(String message) {
        log.error(message);
    }

    public void debug(String message) {
        log.debug(message);
    }
}
