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

public class ExampleTest {
	//Driver manager class
	DriverManager driverManager;
	WebDriver driver;
	RegisterPage register;
  @Test
  public void f() {
	//Assert.assertTrue(register.runLogIn());
	  register.TryRegister();
	  
	  Assert.assertTrue(register.getMessage().contains("Congratulations"));
  }
  @BeforeTest
  public void beforeTest() {
	  //Init ChromeDriver from Factory pattern
	 driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
	 driver = driverManager.getWebDriver();
	 register = new RegisterPage(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
