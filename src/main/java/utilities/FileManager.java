package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class FileManager {
    private static final String allureReportsPath = "target/allure-results";
    private static final String debugEvidenceFolder = "src/test/resources/debugEvidence";
    public static WebDriver staticDriver;

    public static void deleteTestEvidence() {
        try {
            Logs.debug("Deleting debug evidence directory");
            FileUtils.deleteDirectory(new File(debugEvidenceFolder));

            Logs.debug("Deleting allure reports directory");
            FileUtils.deleteDirectory(new File(allureReportsPath));
        } catch (IOException ioException) {
            Logs.error("Failed to delete directory: %s%n", ioException.getLocalizedMessage());
        }
    }

    public static void redirectStdErr() {
        Logs.debug("Redirecting stderr");
        final var file = new File("src/test/resources/logs/stderr.log");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        final var ps = new PrintStream(fos);
        System.setErr(ps);
    }

    @Attachment(value = "failureScreenshot", type = "image/png")
    public static byte[] takeAllureScreenshot() {
        Logs.debug("Taking allure screenshot");
        return ((TakesScreenshot) staticDriver).getScreenshotAs(OutputType.BYTES);
    }

    public static void saveTestEvidence(WebDriver driver, String testName) {
        getPageSourceXML(driver, testName);
        takeScreenshot(driver, testName);
    }

    private static void getPageSourceXML(WebDriver driver, String fileName) {
        Logs.debug("Taking page source");
        final var path = String.format("%s/view-hierarchy-%s.html", debugEvidenceFolder, fileName);
        try {
            Logs.debug("Creating html file: %s", path);
            final var file = new File(path);
            Logs.debug("Creating file parents");
            if (file.getParentFile().mkdirs()) {
                Logs.debug("Writing to html file");
                final var fileWriter = new FileWriter(file);
                fileWriter.write(driver.getPageSource());
                Logs.debug("Closing filewriter");
                fileWriter.close();
            }
        } catch (IOException ioException) {
            Logs.error("Failed to create/write html: %s%n", ioException.getLocalizedMessage());
        }
    }

    private static void takeScreenshot(WebDriver driver, String screenshotName) {
        Logs.debug("Taking screenshot");
        final var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        final var path = String.format("%s/screenshot-%s.png", debugEvidenceFolder, screenshotName);
        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            Logs.error("Failed creating screenshot: %s", ioException.getLocalizedMessage());
        }
    }
}