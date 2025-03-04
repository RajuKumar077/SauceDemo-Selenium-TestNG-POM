package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reporter {

    // Method to log test steps and attach screenshots if test fails
    public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) {
        if (status.equals(Status.PASS)) {
            System.out.println("✔ Step Passed: " + stepMessage);
            test.log(status, stepMessage);
        } else if (status.equals(Status.FAIL)) {
            System.out.println("❌ Step Failed: " + stepMessage);
            String screenshotPath = captureScreenshot(driver, stepMessage);
            test.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    // Method to capture screenshots
    public static String captureScreenshot(WebDriver driver, String stepName) {
        String userDir = System.getProperty("user.dir") + File.separator + "screenshots";

        // Create screenshots directory if it doesn't exist
        File screenshotDir = new File(userDir);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        // Timestamp for unique screenshot names
        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String filePath = userDir + File.separator + stepName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

        // Take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        
        return filePath;
    }
}
