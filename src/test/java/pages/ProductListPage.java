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

public class ProductListPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public ProductListPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	public void selectProduct() {
		Base.sleep(2000);
		driver.findElement(Locators.firstProduct).click();

		try {
			// Explicit wait for 'Back to Products' button
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.backToProduct));

			Reporter.generateReport(driver, test, Status.PASS, "Selecting the product is successful");

		} catch (TimeoutException te) { 
			Reporter.generateReport(driver, test, Status.FAIL, "Selecting the product failed");
		}
	}
}
