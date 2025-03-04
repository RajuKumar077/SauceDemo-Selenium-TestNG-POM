package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import objectrepository.Locators;
import utils.Base;
import utils.Reporter;  

public class LoginPage {

	private WebDriver driver; // WebDriver instance
	private WebDriverWait wait; // WebDriverWait instance for explicit waits
	private ExtentTest test; // ExtentTest instance for reporting

	// Constructor to initialize WebDriver, WebDriverWait, and ExtentTest
	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set timeout for explicit wait
		this.test = test;
	}

	// Method to perform login validation and return boolean result
	public boolean validateLogin(String uname, String pwd) {
		// Enter username
		driver.findElement(Locators.userName).sendKeys(uname);
		Base.sleep(1000); // Pause for stability

		// Enter password
		driver.findElement(Locators.password).sendKeys(pwd);
		Base.sleep(1000); // Pause for stability

		// Click the login button
		driver.findElement(Locators.loginButton).click();

		try {
			// Wait for the "Products" text to appear as a sign of successful login
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));

			// Generate a report indicating login success
			Reporter.generateReport(driver, test, Status.PASS, "Login is Success");
			return true;  // ✅ Login successful

		} catch (TimeoutException te) {
			// Generate a report indicating login failure
			Reporter.generateReport(driver, test, Status.FAIL, "Login is failure");
			return false; // ❌ Login failed
		}
	}
}
