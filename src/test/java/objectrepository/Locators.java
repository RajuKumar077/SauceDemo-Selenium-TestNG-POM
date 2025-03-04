package objectrepository;

import org.openqa.selenium.By;

public class Locators {

	// locators for login page
	public static By userName = By.id("user-name");
	public static By password = By.id("password");
	public static By loginButton = By.id("login-button");

	// locators for Product
	public static By firstProduct = By.xpath("//div[text() ='Sauce Labs Backpack']");
	public static By backToProduct = By.id("back-to-products");

	// locators for addToCart page
	public static By addToCart = By.id("add-to-cart");
	public static By verifyCart = By
			.xpath("//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge' and text() >= '1']");

	// locators for checkoutButton page
	public static By checkoutButton = By.id("checkout");
	public static By verifycheckoutButton = By.id("first-name");

	// locators for filling details page
	public static By firstName = By.id("first-name");
	public static By lastName = By.id("last-name");
	public static By postalCode = By.id("postal-code");
	public static By continuebutton = By.id("continue");
	public static By finish = By.id("finish");

	// locators for LogOFF page
	public static By threeBar = By.xpath("//button[@id ='react-burger-menu-btn']");
	public static By logOff = By.xpath("//a[@id ='logout_sidebar_link']");
}