package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import objectrepository.Locators;
import utils.Base;
import utils.Reporter;

public class LogOffPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public LogOffPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	// fillingDatav Function to fill all the data on page
	public void logoffSite() {

		driver.findElement(Locators.finish).click();
		Base.sleep(1000);
		driver.findElement(Locators.threeBar).click();
		Base.sleep(1000);
				
		//wait for logOff to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.logOff));
		driver.findElement(Locators.logOff).click();
		Base.sleep(1000);
		
		

	}

	
	//moving to next page by clicking continuebutton
	public void logOffConfirm() {
		
		try {
			// Wait until finish page loads
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginButton));
			Reporter.generateReport(driver, test, Status.PASS, "Clicked on LogOff page successfully");
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, " LogOff page click failed");
		}
	}
}
