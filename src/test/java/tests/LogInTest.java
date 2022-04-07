package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.core.DriverManagerFactory;
import framework.core.drivers.DriverManager;
import framework.enums.DriverType;
import pages.LoginPage;

public class LogInTest {
	// Driver manager class
	DriverManager driverManager;
	WebDriver driver;
	LoginPage login;

	@BeforeTest
	public void setup() {
		// Init ChromeDriver from Factory pattern
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		login = new LoginPage(driver);
	}

	@Test
	public void LogInAttempt() {
		// Assert.assertTrue(register.runLogIn());
		login.TryLogIn();
		Assert.assertTrue(login.getMessage().contains("My Account"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
