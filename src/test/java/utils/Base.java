package utils;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public WebDriver driver; // Declare WebDriver instance

    public WebDriver launchBrowser() {
        // Read properties from the configuration file
        Properties prop = PropertyReader.readProperty();
        // Get the browser name from the properties file
        String browser = prop.getProperty("Browser");

        // If the browser property is not set, throw an exception
        if (browser == null) {
            throw new RuntimeException("Browser property is not set in config file.");
        }

        // Initialize WebDriver based on the browser type
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(); // Launch Chrome browser
                break;
            case "firefox":
                driver = new FirefoxDriver(); // Launch Firefox browser
                break;
            case "edge":
                driver = new EdgeDriver(); // Launch Edge browser
                break;
            default:
                throw new IllegalArgumentException("Enter only either chrome, firefox, or edge"); // Handle invalid input
        }

        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to the URL specified in the properties file
        driver.get(prop.getProperty("URL"));
        return driver; // Return the WebDriver instance
    }

    public static void sleep(int msec) {
        try {
            // Pause execution for the specified duration
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            // Properly reset the interrupt status if sleep is interrupted
            Thread.currentThread().interrupt();
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }
}
