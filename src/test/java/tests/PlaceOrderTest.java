package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CustomerInfoPage;
import pages.LogOffPage;
import pages.LoginPage;
import pages.ProductListPage;
import utils.Base;

public class PlaceOrderTest extends Base {

	ExtentSparkReporter spark;
	ExtentReports extReports;
	ExtentTest test;

	@BeforeClass
	public void setUpReports() {
		spark = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);

	}

	@AfterClass
	public void writeReport() {
		extReports.flush();
	}

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	@Test
	public void testPlaceOrder() {

		// to create test case in Extent Report
		test = extReports.createTest("Place Order");

		// login step
		LoginPage loginPage = new LoginPage(driver, test);
		loginPage.validateLogin("standard_user", "secret_sauce");

		// select product
		ProductListPage prodListPage = new ProductListPage(driver, test);
		prodListPage.selectProduct();

		// Add to cart
		CartPage cartProd = new CartPage(driver, test);
		cartProd.addToCart();

		// checkout
		CheckoutPage checkOut = new CheckoutPage(driver, test);
		checkOut.goToCart();
		checkOut.clickCheckout();

		// customer info
		CustomerInfoPage customerInfoPage = new CustomerInfoPage(driver, test);
		customerInfoPage.fillingData();
		customerInfoPage.nextcontinue();

		// log-off page
		LogOffPage logoff = new LogOffPage(driver, test);
		logoff.logoffSite();
		logoff.logOffConfirm();

	}

	@AfterMethod
	public void tearDown() {
		Base.sleep(4000);
		driver.quit();
	}

}
