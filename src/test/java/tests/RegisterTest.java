package tests;

import org.testng.annotations.Test;

import framework.core.DriverManagerFactory;
import framework.core.drivers.DriverManager;
import framework.enums.DriverType;
import pages.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegisterTest {
	// Driver manager class
	DriverManager driverManager;
	WebDriver driver;
	RegisterPage register;


	@BeforeTest
	public void setup() {
		// Init ChromeDriver from Factory pattern
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		register = new RegisterPage(driver);
	}
	
	@Test
	public void RegisterAccount() {
		// Assert.assertTrue(register.runLogIn());
		register.TryRegister();

		Assert.assertTrue(register.getMessage().contains("Congratulations"));
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
