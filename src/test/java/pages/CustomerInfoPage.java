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

public class CustomerInfoPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public CustomerInfoPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		this.test = test;
	}

	// fillingDatav Function to fill all the data on page
	public void fillingData() {

		driver.findElement(Locators.firstName).sendKeys("Raju");
		Base.sleep(1000);
		driver.findElement(Locators.lastName).sendKeys("Kumar");
		Base.sleep(1000);
		driver.findElement(Locators.postalCode).sendKeys("841426");
		Base.sleep(1000);
		
		

	}

	//moving to next page by clicking continuebutton
	public void nextcontinue() {
		driver.findElement(Locators.continuebutton).click();

		try {
			// Wait until finish page loads
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.finish));
			Reporter.generateReport(driver, test, Status.PASS, "Clicked on finish page successfully");
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "finish page click failed");
		}
	}
}
