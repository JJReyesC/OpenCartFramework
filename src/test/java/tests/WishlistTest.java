package tests;

import org.testng.annotations.Test;

import framework.core.DriverManagerFactory;
import framework.core.drivers.DriverManager;
import framework.enums.DriverType;
import pages.LoginPage;
import pages.WishlistPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class WishlistTest {
	// Driver manager class
	DriverManager driverManager;
	WebDriver driver;
	LoginPage login;
	WishlistPage wishlist;

	@BeforeTest
	public void setup() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		login = new LoginPage(driver);
		wishlist = new WishlistPage(driver);
	}

	@Test
	public void addToWishlist() {
		login.TryLogIn();
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
