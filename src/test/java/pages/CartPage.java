package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Base;
import utils.Reporter;

public class CartPage {
	private WebDriver driver; // WebDriver instance for interacting with the browser
	private WebDriverWait wait; // WebDriverWait instance for explicit waits
	private ExtentTest test; // ExtentTest instance for reporting

	// Constructor to initialize WebDriver, WebDriverWait, and ExtentTest
	public CartPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set timeout for explicit wait
		this.test = test;
	}

	// Method to add a product to the cart
	public void addToCart() {
		// Click on the "Add to Cart" button
		driver.findElement(Locators.addToCart).click();
		Base.sleep(1000);

		try {
			// Explicit wait to ensure 'Back to Products' button appears, confirming the product is added
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyCart));

			// Generate a report indicating the product was added successfully
			Reporter.generateReport(driver, test, Status.PASS, "Product Added to Cart successfully");

		} catch (TimeoutException te) { 
			// Generate a report indicating the product addition failed
			Reporter.generateReport(driver, test, Status.FAIL, "Product Added to Cart failed");
		}
	}
}
