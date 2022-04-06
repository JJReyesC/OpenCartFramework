package tests;

import org.testng.annotations.Test;

import pages.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ExampleTest {
	
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
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\guillermow.gonzalez\\Downloads\\chromedriver.exe");
	 driver = new ChromeDriver();
	 register = new RegisterPage(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
